package com.interview.multithreading.realworld_issues;

public class ReorderingDemo {
    static int a = 0, b = 0;
    static int x = 0, y = 0;

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1000000; i++) {
            a = b = x = y = 0;
            Thread t1 = new Thread(() -> {
                a = 1;        // write a
                x = b;        // read b into x
            });

            Thread t2 = new Thread(() -> {
                b = 1;        // write b
                y = a;        // read a into y
            });

            t1.start(); t2.start();
            t1.join(); t2.join();

            if (x == 0 && y == 0) {
                System.out.println("Reordering observed: x=0 y=0 at iteration " + i);
                break;
            }
        }
    }
}
