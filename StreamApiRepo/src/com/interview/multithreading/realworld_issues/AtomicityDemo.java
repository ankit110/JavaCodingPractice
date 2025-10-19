package com.interview.multithreading.realworld_issues;

public class AtomicityDemo {
    static int counter = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[10];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    counter++;         // not atomic: read, add, write
                }
            });
            threads[i].start();
        }
        for (Thread t : threads) t.join();
        System.out.println("Expected 10000, actual " + counter);
    }
}
