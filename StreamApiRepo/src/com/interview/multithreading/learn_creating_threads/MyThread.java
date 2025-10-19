package com.interview.multithreading.learn_creating_threads;

public class MyThread extends Thread {
    public void run() {
        System.out.println("Thread is running:- " + Thread.currentThread().getName());
    }
}

class ThreadExample {
    public static void main(String[] args) throws InterruptedException {
        MyThread thread = new MyThread();

        MyThread t2 = new MyThread();

        thread.start(); // Starts new thread

        thread.join(); // join() → makes the calling thread (main) wait for the other thread to finish.
        t2.start();
        t2.join();
        System.out.println("Main Thread:- " + Thread.currentThread().getName());
    }
}