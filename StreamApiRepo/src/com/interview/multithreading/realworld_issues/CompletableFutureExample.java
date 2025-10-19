package com.interview.multithreading.realworld_issues;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureExample {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(2);

        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Task executed on thread:- " + Thread.currentThread().getName();
        }, service);

        future.thenAccept(result -> {
            System.out.println("Task Completed on Thread:- " + Thread.currentThread().getName());
            System.out.println("Result:- " + result);
        });

        CompletableFuture.supplyAsync(() -> {
            throw new RuntimeException();
        }).exceptionally(ex -> {
            System.out.println("Exception Handled.!" + ex.getMessage());
            return "abc";
        }).thenAccept(
            System.out::println
        );

        System.out.println(":Main is doing some other work parallely. " + Thread.currentThread().getName());
        Thread.sleep(5000);

        System.out.println("Main Thread finished." + Thread.currentThread().getName());

        service.shutdown();
    }
}
