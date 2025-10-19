package com.interview.multithreading.learn_creating_threads;

import java.util.concurrent.*;

public class SubmitExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        Callable<Integer> task = () -> {
            System.out.println("Task running on " + Thread.currentThread().getName());
            return 10 / 0; // ❌ Exception
        };

        Future<Integer> future = executor.submit(task);

        try {
            Integer result = future.get(); // Blocks until task finishes
            System.out.println("Result: " + result);
        } catch (ExecutionException e) {
            System.err.println("Task failed: " + e.getCause()); // <- Original exception
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        executor.shutdown();
    }
}
