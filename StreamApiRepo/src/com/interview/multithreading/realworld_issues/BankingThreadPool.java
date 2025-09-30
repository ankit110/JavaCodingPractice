package com.interview.multithreading.realworld_issues;

import java.util.concurrent.*;

public class BankingThreadPool {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                2, 4, 10, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(2), // queue size = 2
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy() // rejection policy
        );

        for (int i = 1; i <= 10; i++) {
            int taskId = i;
            executor.submit(() -> {
                System.out.println("Processing transaction " + taskId +
                                   " by " + Thread.currentThread().getName());
                try { Thread.sleep(2000); } catch (InterruptedException e) {}
            });
        }

        executor.shutdown();
    }
}
