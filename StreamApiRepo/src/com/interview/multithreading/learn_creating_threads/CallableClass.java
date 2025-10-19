package com.interview.multithreading.learn_creating_threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class CallableClass implements Callable<String> {

    int taskId;

    public CallableClass(int taskId) {
        this.taskId = taskId;
    }

    public String call() {
        return "This method call with taskId " + taskId + " is returned on Thread:- " + Thread.currentThread().getName();
    }
}

class CallableMain {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        List<Future<String>> futureList = new ArrayList<>();

        for(int i = 0; i < 10; i++) {
            futureList.add(executor.submit(new CallableClass((i+1) * 2)));
        }

        for(int i = 0; i < futureList.size(); i++) {
            try {
                String result = futureList.get(i).get();
                System.out.println("Result:- " + result);
            } catch(InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Interrupted while waiting for result.");
            } catch (ExecutionException e) {
                System.err.println("Task with id " + (i+2) * 2 + " failed: " + e.getCause());
            }
        }

        executor.shutdown();
    }
}
