package com.interview.multithreading.realworld_issues;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureExample {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        Future<String> futureRes = executor.submit(() -> {
            Thread.sleep(3000);
            return "Future task is executed on Thread:- " + Thread.currentThread().getName();
        });

        String res = futureRes.get();

        System.out.println("Res:- " + res);
        System.out.println("Main Thread: " + Thread.currentThread().getName());

        executor.shutdown();
    }
}
