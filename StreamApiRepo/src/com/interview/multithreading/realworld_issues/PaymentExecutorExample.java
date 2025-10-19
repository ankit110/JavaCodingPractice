package com.interview.multithreading.realworld_issues;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class PaymentExecutorExample {

    public static void main(String[] args) {

        // Create a pool of 3 worker threads
        ExecutorService pool = Executors.newFixedThreadPool(3);

        // Define a payment processing task (Callable returns a value)
        Callable<String> paymentTask = () -> {
            String thread = Thread.currentThread().getName();
            System.out.println("Processing payment on: " + thread);

            // Simulate random failure
            if (Math.random() > 0.5) {
                throw new RuntimeException("Payment failed on " + thread);
            }

            // Simulate success
            return "✅ Payment success from " + thread;
        };

        // Submit multiple tasks to the pool
        Future<String> result1 = pool.submit(paymentTask);
        Future<String> result2 = pool.submit(paymentTask);
        Future<String> result3 = pool.submit(paymentTask);

        try {
            // future.get() blocks until the result is ready (or an exception is thrown)
            System.out.println("Result 1: " + result1.get());
        } catch (ExecutionException e) {
            System.err.println("❌ Payment error: " + e.getCause().getMessage());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        try {
            System.out.println("Result 2: " + result2.get());
        } catch (ExecutionException e) {
            System.err.println("❌ Payment error: " + e.getCause().getMessage());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        try {
            System.out.println("Result 3: " + result3.get());
        } catch (ExecutionException e) {
            System.err.println("❌ Payment error: " + e.getCause().getMessage());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Always shut down the pool to release threads
        pool.shutdown();
    }
}
