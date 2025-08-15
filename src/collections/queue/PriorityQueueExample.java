package collections.queue;

import java.util.PriorityQueue;

public class PriorityQueueExample {

    // PriorityQueue
    // Using default constructor - uses natural ordering of numbers
    // Smaller numbers have higher priority

    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(24);
        priorityQueue.offer(15);
        priorityQueue.offer(9);
        priorityQueue.offer(32);

        System.out.println(priorityQueue);

        // poll method gets the element with the highest priority.

        priorityQueue.poll();
        System.out.println(priorityQueue);

        priorityQueue.poll();
        System.out.println(priorityQueue);
    }

}
