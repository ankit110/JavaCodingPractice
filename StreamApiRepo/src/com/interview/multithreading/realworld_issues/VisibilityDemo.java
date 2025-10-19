package com.interview.multithreading.realworld_issues;

public class VisibilityDemo {
//    static boolean flag = false;     // not volatile
    static volatile boolean flag = false;
    static String message = null;

    public static void main(String[] args) throws InterruptedException {
        Thread writer = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            message = "Hello";
            flag = true;                // set flag true
        });

        Thread reader = new Thread(() -> {
            while (!flag) {             // busy-wait until flag becomes true
                // without visibility guarantees, this might loop forever or see stale value
            }
            System.out.println("Message: " + message);
        });

        reader.start();
        writer.start();

        writer.join();
        reader.join();
    }
}
