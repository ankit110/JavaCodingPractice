package com.interview.multithreading.learn_creating_threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunnableClass implements Runnable {

    int taskId;

    public RunnableClass(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public void run() {
        System.out.println("Task with taskId " + taskId + " is running on Thread :- " + Thread.currentThread().getName());
    }
}

class RunnableMain {
    public static void main(String [] args) throws InterruptedException {
//        RunnableClass runnable = new RunnableClass();
//        Thread t1 = new Thread(runnable);
//        Thread t2 = new Thread(runnable);
//        Thread t3 = new Thread(runnable);
//        Thread t4 = new Thread(runnable);
//
//        t1.start();
//        t2.start();
//        t3.start();
//        t4.start();
//
//        t1.join();
//        t2.join();
//        t3.join();
//        t4.join();
//
//        System.out.println("Main method is running on Thread:- " + Thread.currentThread().getName());

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        executorService.submit(new RunnableClass(1));
        executorService.submit(new RunnableClass(2));
        executorService.submit(new RunnableClass(3));
        executorService.submit(new RunnableClass(4));
        executorService.submit(new RunnableClass(5));

        executorService.shutdown();
    }
}
