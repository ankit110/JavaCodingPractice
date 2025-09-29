package com.interview.multithreading.realworld_issues;

public class Account {

    int balance = 100;

//    public void withdraw(int amount) {
//        if(balance >= amount) {
//            System.out.println(Thread.currentThread().getName() + " is withdrawing amount:- Rs" + amount);
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException ex) {
//                System.out.println("Execution Interrupted");
//            }
//
//            balance = balance - amount;
//            System.out.println(Thread.currentThread().getName() + " completed withdrawal. New Balance = " + balance);
//        } else {
//            System.out.println("Insufficient Balance for = " + Thread.currentThread().getName());
//        }
//    }
//----------------------------------------------------------------------------------------------------------

//    synchronized method
//    👉 Now only one thread can enter withdraw() at a time.

//    public synchronized void withdraw(int amount) {
//        if(balance >= amount) {
//
//            System.out.println(Thread.currentThread().getName() + " is withdrawing amount:- Rs " + amount);
//
//            try {
//                Thread.sleep(100);
//            } catch(InterruptedException ex) {
//                System.out.println("Execution interrupted.");
//            }
//
//            balance = balance - amount;
//
//            System.out.println(Thread.currentThread().getName() + " completed withdrawal. New Balance = Rs " + balance);
//        } else {
//            System.out.println("Insufficient Balance for = " + Thread.currentThread().getName());
//        }
//    }

//------------------------------------------------------------------------------------------------------------------

//    synchronized block(more control)
//    👉 More efficient, since you lock only the critical section (code that touches shared resource).
    public void withdraw(int amount) {
        synchronized (this) {
            if(balance >= amount) {

                System.out.println(Thread.currentThread().getName() + " is withdrawing amount:- Rs " + amount);

                try {
                    Thread.sleep(100);
                } catch(InterruptedException ex) {
                    System.out.println("Execution interrupted.");
                }

                balance = balance - amount;

                System.out.println(Thread.currentThread().getName() + " completed withdrawal. New Balance = Rs " + balance);
            } else {
                System.out.println("Insufficient Balance for = " + Thread.currentThread().getName());
            }
        }

    }
}
