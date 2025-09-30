package com.interview.multithreading.realworld_issues;
// CompletableFutureBankDemo.java
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class CompletableFutureBankDemo {

    // Simple Account data structure (not thread-safe for demo simplicity)
    static class Account {
        final String id;
        private int balance;

        Account(String id, int initial) { this.id = id; this.balance = initial; }

        public synchronized int getBalance() { return balance; }
        public synchronized void deposit(int amount) { balance += amount; }
        public synchronized void withdraw(int amount) { balance -= amount; }

        @Override public String toString() { return id + "(balance=" + getBalance() + ")"; }
    }

    // Simulated remote services with latency and occasional failure
    static class AccountService {
        private final Random rnd = new Random();
        private final int latencyMinMs;
        private final int latencyMaxMs;

        AccountService(int latencyMinMs, int latencyMaxMs) {
            this.latencyMinMs = latencyMinMs;
            this.latencyMaxMs = latencyMaxMs;
        }

        private void simulateLatency() {
            try { Thread.sleep(latencyMinMs + rnd.nextInt(Math.max(1, latencyMaxMs - latencyMinMs))); }
            catch (InterruptedException ignored) { Thread.currentThread().interrupt(); }
        }

        // Blocking method (like a DB call) that returns balance
        public int fetchBalanceBlocking(Account acct) {
            simulateLatency();
            System.out.printf("[%s] (blocking) fetched balance %d for %s%n",
                    Thread.currentThread().getName(), acct.getBalance(), acct.id);
            return acct.getBalance();
        }

        // Blocking transfer: withdraw from source and deposit to dest (returns transferId)
        public String transferBlocking(Account from, Account to, int amount) {
            simulateLatency();
            // naive check and update (synchronized in account); might throw on insufficient funds
            synchronized (from) {
                if (from.getBalance() < amount) throw new IllegalStateException("Insufficient funds in " + from.id);
                from.withdraw(amount);
            }
            synchronized (to) {
                to.deposit(amount);
            }
            String txId = "tx-" + Math.abs(rnd.nextInt());
            System.out.printf("[%s] (blocking) completed transfer %s: %s -> %s amount=%d%n",
                    Thread.currentThread().getName(), txId, from.id, to.id, amount);
            return txId;
        }
    }

    static class NotificationService {
        private final Random rnd = new Random();
        void notifyUser(String userId, String message) {
            try { Thread.sleep(50 + rnd.nextInt(100)); } catch (InterruptedException ignored) { Thread.currentThread().interrupt(); }
            System.out.printf("[%s] Notified %s: %s%n", Thread.currentThread().getName(), userId, message);
        }
    }

    public static void main(String[] args) throws Exception {
        // Create a controlled Executor (pool for async tasks)
        ExecutorService pool = Executors.newFixedThreadPool(4, r -> {
            Thread t = new Thread(r);
            t.setName("async-pool-" + t.getId());
            return t;
        });

        AccountService accountService = new AccountService(80, 200); // simulate 80-200ms latency
        NotificationService notificationService = new NotificationService();

        Account alice = new Account("Alice", 1000);
        Account bob = new Account("Bob", 300);

        System.out.println("Initial: " + alice + ", " + bob);
        System.out.println("---- Part A: Callable + Future (blocking) example ----");

        // ------------ Part A: Callable + Future (blocking) ----------------
        Callable<Integer> balanceTask = () -> accountService.fetchBalanceBlocking(alice);
        Future<Integer> futureBalance = pool.submit(balanceTask);

        System.out.println("[main] Doing other work while balance is fetched...");
        // This will block until result available
        int balance = futureBalance.get(); // blocking!
        System.out.println("[main] Got balance via Future.get(): " + balance);

        System.out.println("\n---- Part B: CompletableFuture pipeline (non-blocking) ----");

        // -------------- Part B: CompletableFuture pipeline ----------------
        // We will: 1) check balance async, 2) if enough -> perform transfer async (debit->credit),
        // 3) then send notification async, and 4) handle failures gracefully.

        int amountToTransfer = 250;

        // Step 1: check balance asynchronously (non-blocking)
        CompletableFuture<Integer> checkBalanceCF = CompletableFuture.supplyAsync(
                () -> accountService.fetchBalanceBlocking(alice), pool);

        // Step 2: conditionally start transfer if funds available
        CompletableFuture<String> transferCF = checkBalanceCF.thenCompose(balanceAvailable -> {
            if (balanceAvailable < amountToTransfer) {
                // Fail fast: return a completed exceptionally future
                CompletableFuture<String> failed = new CompletableFuture<>();
                failed.completeExceptionally(new IllegalStateException("Insufficient funds: " + balanceAvailable));
                return failed;
            }
            // Otherwise do transfer asynchronously and return transfer id
            return CompletableFuture.supplyAsync(() -> accountService.transferBlocking(alice, bob, amountToTransfer), pool);
        });

        // Step 3: after transfer, send notification (async) and return transfer id for logging
        CompletableFuture<String> pipeline = transferCF.thenApplyAsync(txId -> {
            String message = "Transfer " + txId + " completed: " + amountToTransfer + " from " + alice.id + " to " + bob.id;
            // notify asynchronously using pool (but inside thenApplyAsync we'll be on pool thread)
            notificationService.notifyUser(alice.id, message);
            notificationService.notifyUser(bob.id, message);
            return txId;
        }, pool);

        // Step 4: error handling - provide fallback and log
        CompletableFuture<String> safePipeline = pipeline
                .exceptionally(ex -> {
                    System.out.printf("[%s] Pipeline failed: %s%n", Thread.currentThread().getName(), ex.getMessage());
                    // maybe trigger compensating action or notify ops — for demo return special token
                    return "FAILED";
                });

        // Non-blocking: we can attach more behavior to run after completion
        safePipeline.thenAccept(result -> System.out.println("[main] Pipeline finished with result=" + result));

        // Meanwhile main can continue doing other work
        System.out.println("[main] Doing other work while transfer pipeline runs...");

        // Wait for pipeline to finish (for demo only)
        safePipeline.get(); // blocks here only because demo wants to wait for output

        System.out.println("Final: " + alice + ", " + bob);

        System.out.println("\n---- Part C: Combining parallel calls (thenCombine / allOf) ----");

        // Example: fetch balances of multiple accounts in parallel and combine
        List<Account> accounts = Arrays.asList(alice, bob, new Account("Service", 5000));
        List<CompletableFuture<Integer>> balanceFutures = accounts.stream()
                .map(ac -> CompletableFuture.supplyAsync(() -> accountService.fetchBalanceBlocking(ac), pool))
                .toList();

        // Wait for all and compute total balance
        CompletableFuture<Void> all = CompletableFuture.allOf(balanceFutures.toArray(new CompletableFuture[0]));
        CompletableFuture<Integer> totalBalanceCF = all.thenApply(v ->
                balanceFutures.stream().mapToInt(cf -> cf.join()).sum() // join is safe because allOf completed
        );

        System.out.println("[main] Total balance across accounts: " + totalBalanceCF.get());

        // cleanup
        pool.shutdown();
        pool.awaitTermination(5, TimeUnit.SECONDS);
        System.out.println("Demo completed.");
    }
}
