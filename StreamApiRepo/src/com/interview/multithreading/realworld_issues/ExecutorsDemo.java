package com.interview.multithreading.realworld_issues;// ExecutorsDemo.java
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ExecutorsDemo {

    // Simple task that prints thread name and sleeps a bit
    static class DemoTask implements Runnable {
        private final int id;
        DemoTask(int id) { this.id = id; }
        @Override
        public void run() {
            System.out.printf("[%s] Task-%d START%n", Thread.currentThread().getName(), id);
            try {
                // Simulate variable work
                Thread.sleep(200 + (id % 3) * 150);
            } catch (InterruptedException e) {
                System.out.printf("[%s] Task-%d INTERRUPTED%n", Thread.currentThread().getName(), id);
                Thread.currentThread().interrupt();
            }
            System.out.printf("[%s] Task-%d END%n", Thread.currentThread().getName(), id);
        }
    }

    // Custom thread factory to name threads for easier observation
    static ThreadFactory namedThreadFactory(String baseName) {
        final AtomicInteger cnt = new AtomicInteger(1);
        return r -> {
            Thread t = new Thread(r);
            t.setName(baseName + "-" + cnt.getAndIncrement());
            return t;
        };
    }

    // Demo for newFixedThreadPool(n)
    static void demoFixedThreadPool() throws InterruptedException {
        System.out.println("\n=== newFixedThreadPool(3) demo ===");
        ExecutorService fixed = Executors.newFixedThreadPool(3, namedThreadFactory("fixed"));

        // Submit 8 tasks while pool size is 3 -> 3 run concurrently, rest queued
        for (int i = 1; i <= 8; i++) {
            fixed.submit(new DemoTask(i));
        }

        fixed.shutdown(); // no new tasks
        if (!fixed.awaitTermination(5, TimeUnit.SECONDS)) {
            fixed.shutdownNow();
        }
        System.out.println("Fixed pool finished\n");
    }

    // Demo for newCachedThreadPool()
    static void demoCachedThreadPool() throws InterruptedException {
        System.out.println("\n=== newCachedThreadPool() demo ===");
        ExecutorService cached = Executors.newCachedThreadPool(namedThreadFactory("cached"));

        // Submit many short tasks quickly — cached pool creates new threads as needed
        for (int i = 1; i <= 10; i++) {
            cached.submit(new DemoTask(i));
            // tiny gap so we can see threads appear (but tasks are short)
            try { Thread.sleep(30); } catch (InterruptedException ignored) {}
        }

        cached.shutdown();
        if (!cached.awaitTermination(6, TimeUnit.SECONDS)) cached.shutdownNow();
        System.out.println("Cached pool finished\n");
    }

    // Demo for newSingleThreadExecutor()
    static void demoSingleThreadExecutor() throws InterruptedException {
        System.out.println("\n=== newSingleThreadExecutor() demo ===");
        ExecutorService single = Executors.newSingleThreadExecutor(namedThreadFactory("single"));

        // Tasks will run sequentially on a single thread
        for (int i = 1; i <= 5; i++) {
            single.submit(new DemoTask(i));
        }

        single.shutdown();
        if (!single.awaitTermination(5, TimeUnit.SECONDS)) single.shutdownNow();
        System.out.println("Single-thread executor finished\n");
    }

    // Demo for newScheduledThreadPool(n)
    static void demoScheduledThreadPool() throws InterruptedException {
        System.out.println("\n=== newScheduledThreadPool(2) demo ===");
        ScheduledExecutorService sched = Executors.newScheduledThreadPool(2, namedThreadFactory("sched"));

        // schedule a one-shot delayed task
        sched.schedule(() -> System.out.printf("[%s] Delayed task executed%n", Thread.currentThread().getName()),
                500, TimeUnit.MILLISECONDS);

        // scheduleAtFixedRate: fixed-rate attempts to keep a constant frequency
        final ScheduledFuture<?> fixedRateHandle = sched.scheduleAtFixedRate(
                () -> System.out.printf("[%s] FixedRate tick%n", Thread.currentThread().getName()),
                200, 700, TimeUnit.MILLISECONDS);

        // scheduleWithFixedDelay: next execution delayed after previous completes
        final ScheduledFuture<?> fixedDelayHandle = sched.scheduleWithFixedDelay(
                () -> {
                    System.out.printf("[%s] FixedDelay tick START%n", Thread.currentThread().getName());
                    try { Thread.sleep(400); } catch (InterruptedException ignored) {}
                    System.out.printf("[%s] FixedDelay tick END%n", Thread.currentThread().getName());
                },
                200, 700, TimeUnit.MILLISECONDS);

        // Let scheduled tasks run for a while then cancel periodic tasks
        Thread.sleep(3000);
        System.out.println("Cancelling periodic tasks...");
        fixedRateHandle.cancel(false);     // do not interrupt if running
        fixedDelayHandle.cancel(false);

        sched.shutdown();
        if (!sched.awaitTermination(3, TimeUnit.SECONDS)) sched.shutdownNow();
        System.out.println("Scheduled pool finished\n");
    }

    // Extra: show underlying ThreadPoolExecutor parameters for each factory type (info)
    static void showExecutorDetails() {
        System.out.println("Quick internals summary (for interview):");
        System.out.println("- newFixedThreadPool(n): core=n, max=n, keepAlive=0, queue=LinkedBlockingQueue (unbounded).");
        System.out.println("- newCachedThreadPool(): core=0, max=Integer.MAX_VALUE, keepAlive=60s, queue=SynchronousQueue (no queueing).");
        System.out.println("- newSingleThreadExecutor(): core=1, max=1, queue=LinkedBlockingQueue (unbounded).");
        System.out.println("- newScheduledThreadPool(n): implemented by ScheduledThreadPoolExecutor (core=n), supports delay and periodic tasks.");
    }

    public static void main(String[] args) throws InterruptedException {
        showExecutorDetails();

        demoFixedThreadPool();
        demoCachedThreadPool();
        demoSingleThreadExecutor();
        demoScheduledThreadPool();

        System.out.println("All demos completed.");
    }
}
