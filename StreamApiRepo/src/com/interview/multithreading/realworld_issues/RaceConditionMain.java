package com.interview.multithreading.realworld_issues;

public class RaceConditionMain {

    public static void main(String[] args) throws InterruptedException {
        Account account = new Account();

        Thread t1 = new Thread(new MoneyWithdrwal(account, 80), "T1");
        Thread t2 = new Thread(new MoneyWithdrwal(account, 70), "T2");
        Thread t3 = new Thread(new MoneyWithdrwal(account, 80), "T3");

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

//        👉 If two threads run withdraw(100) at the same time
//        → both may see balance=100 → both withdraw → final balance becomes negative 🤯 (data inconsistency).
//        Here we need synchronization (to protect shared resources).

        System.out.println("Main Thread:- " + Thread.currentThread().getName());
    }

}
