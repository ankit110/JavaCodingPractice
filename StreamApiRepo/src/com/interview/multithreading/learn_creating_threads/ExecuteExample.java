package com.interview.multithreading.learn_creating_threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecuteExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        executor.execute(() -> {
            System.out.println("Task started on " + Thread.currentThread().getName());
            try {
                int x = 10 / 0;
            } catch (Exception e) {
                System.err.println("Error: " + e.getMessage());
            }
        });

        executor.shutdown();
        System.out.println("Main thread finished");
    }
}
