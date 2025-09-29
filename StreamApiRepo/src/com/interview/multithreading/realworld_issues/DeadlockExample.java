package com.interview.multithreading.realworld_issues;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

class Accounts {
    private int balance = 100;
    private final String name;
    final ReentrantLock lock = new ReentrantLock();

    public Accounts(String name) {
        this.name = name;
    }

    public void withdraw(int amount) {
        System.out.println(Thread.currentThread().getName() + " name.");
        balance -= amount;
    }

    public void deposit(int amount) {
        balance += amount;
    }

    public int getBalance() {
        return balance;
    }

    public String getName() {
        return name;
    }
}

class TransferTask implements Runnable {
    private Accounts from;
    private Accounts to;
    private int amount;

    public TransferTask(Accounts from, Accounts to, int amount) {
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

//    @Override
//    public void run() {
//        synchronized (from) {
//            System.out.println(Thread.currentThread().getName() + " locked " + from.getName());
//
//            try { Thread.sleep(100); } catch (InterruptedException e) { e.printStackTrace(); }
//
//            synchronized (to) {
//                System.out.println(Thread.currentThread().getName() + " locked " + to.getName());
//                from.withdraw(amount);
//                to.deposit(amount);
//                System.out.println(Thread.currentThread().getName() + " completed transfer");
//            }
//        }
//    }

//------------------------------------------------------------------------------------------------------

// 🛠 1. Fix Deadlock with Lock Ordering
//  ✅ Here both threads lock accounts in alphabetical order.
//
//Even if Thread-1 does A → B and Thread-2 does B → A, both will lock AccountA first → no deadlock.
//    @Override
//    public void run() {
//        Accounts first = from.getName().compareTo(to.getName()) < 0 ? from : to;
//        Accounts second = (first == from) ? to : from;
//
//        synchronized (first) {
//            System.out.println(Thread.currentThread().getName() + " locked " + first.getName());
//
//            try { Thread.sleep(100); } catch (InterruptedException e) {}
//
//            synchronized (second) {
//                System.out.println(Thread.currentThread().getName() + " locked " + second.getName());
//                from.withdraw(amount);
//                to.deposit(amount);
//                System.out.println(Thread.currentThread().getName() + " completed transfer");
//            }
//        }
//    }
//----------------------------------------------------------------------------------------------------------------------------
    //    🛠 2. Fix Deadlock with ReentrantLock tryLock()
//    ✅ Now, if both threads collide → one will fail to get the second lock and back off.
//👉 This prevents permanent deadlock.
    @Override
    public void run() {
        try {
            if (from.lock.tryLock(1, TimeUnit.SECONDS)) {
                try {
                    if (to.lock.tryLock(1, TimeUnit.SECONDS)) {
                        try {
                            from.withdraw(amount);
                            to.deposit(amount);
                            System.out.println(Thread.currentThread().getName() +
                                " completed transfer from " + from.getName() + " to " + to.getName());
                        } finally {
                            to.lock.unlock();
                        }
                    } else {
                        System.out.println(Thread.currentThread().getName() +
                            " could not lock " + to.getName() + ", retrying later...");
                    }
                } finally {
                    from.lock.unlock();
                }
            } else {
                System.out.println(Thread.currentThread().getName() +
                    " could not lock " + from.getName() + ", retrying later...");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class DeadlockExample {
    public static void main(String[] args) {
        Accounts acc1 = new Accounts("Account1");
        Accounts acc2 = new Accounts("Account2");

        Thread t1 = new Thread(new TransferTask(acc1, acc2, 50), "Thread-1");
        Thread t2 = new Thread(new TransferTask(acc2, acc1, 50), "Thread-2");

        t1.start();
        t2.start();
    }
}
