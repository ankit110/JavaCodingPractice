package com.interview.multithreading.realworld_issues;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class Producer implements Runnable {
    private final BlockingQueue<Integer> queue;

    public Producer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 5; i++) {
                queue.put(i); // blocks if queue is full
                System.out.println("Produced: " + i);
                Thread.sleep(200);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

class Consumer implements Runnable {
    private final BlockingQueue<Integer> queue;

    public Consumer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 5; i++) {
                int value = queue.take(); // blocks if queue is empty
                System.out.println("Consumed: " + value);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

public class ProducerConsumerBlockingQueue {
    public static void main(String[] args) {
        BlockingQueue<Integer> buffer = new ArrayBlockingQueue<>(2); // capacity 2

        Thread producer = new Thread(new Producer(buffer), "Producer");
        Thread consumer = new Thread(new Consumer(buffer), "Consumer");

        producer.start();
        consumer.start();
    }
}
