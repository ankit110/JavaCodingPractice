package com.interview.multithreading.learn_creating_threads;

public class MyRunnable implements Runnable {

    public void run() {
        System.out.println("Thread is running:- " + Thread.currentThread().getName());
    }
}

class MyRunnableExample {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new MyRunnable());

        t1.start();
        t1.join();
        System.out.println("Main Thread is running:- " + Thread.currentThread().getName());
    }
}
