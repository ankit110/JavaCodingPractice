package com.interview.multithreading.realworld_issues;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Base class with some shared functionality
class BaseService {
    void logStart() {
        System.out.println("Service started by " + Thread.currentThread().getName());
    }
}

// PaymentService implements Runnable
class PaymentService extends BaseService implements Runnable {
    private String paymentId;

    public PaymentService(String paymentId) {
        this.paymentId = paymentId;
    }

    @Override
    public void run() {
        logStart(); // inherited from BaseService
        processPayment();
    }

    private void processPayment() {
        System.out.println("Processing payment " + paymentId + " on thread " + Thread.currentThread().getName());
    }
}

public class ExecutorPaymentExample {
    public static void main(String[] args) {
        // Create a thread pool with 3 threads
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Submit multiple payment tasks to the executor
        executor.submit(new PaymentService("PAY-101"));
        executor.submit(new PaymentService("PAY-102"));
        executor.submit(new PaymentService("PAY-103"));
        executor.submit(new PaymentService("PAY-104")); // extra task queued

        // Shutdown the executor after tasks finish
        executor.shutdown();
    }
}
