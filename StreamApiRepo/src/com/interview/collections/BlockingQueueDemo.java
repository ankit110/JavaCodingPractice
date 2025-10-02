package com.interview.collections;

import java.util.concurrent.*;

public class BlockingQueueDemo {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5); // capacity 5

        // Producer thread
        Runnable producer = () -> {
            int value = 0;
            try {
                while (true) {
                    System.out.println("Producer produced: " + value);
                    queue.put(value); // blocks if queue is full
                    value++;
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };

        // Consumer thread
        Runnable consumer = () -> {
            try {
                while (true) {
                    Integer val = queue.take(); // blocks if queue is empty
                    System.out.println("Consumer consumed: " + val);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };

        new Thread(producer).start();
        new Thread(consumer).start();
    }
}
