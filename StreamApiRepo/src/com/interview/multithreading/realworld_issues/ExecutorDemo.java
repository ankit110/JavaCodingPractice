package com.interview.multithreading.realworld_issues;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorDemo {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(3);
//        ✅ Output: Only 3 threads are reused to process 10 tasks.
//          This is scalable (no 10 new threads created).
//          Executor manages a queue of pending tasks.

        for(int i = 0; i < 10; i++) {
            int taskId = i + 1;
            executor.submit(() -> {
                System.out.println("Task Id is:- " + taskId + " running Thread " + Thread.currentThread().getName());
            });
        }
        executor.shutdown();
    }
}
