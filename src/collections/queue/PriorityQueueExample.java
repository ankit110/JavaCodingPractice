package collections.queue;

import java.util.Comparator;
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

        Comparator<Integer> reverseComparator = new Comparator<Integer>() {
            public int compare(Integer param1, Integer param2) {
                return param2 - param1;
            }
        };

        PriorityQueue<Integer> priorityQueue1 = new PriorityQueue<>(reverseComparator);

        priorityQueue1.offer(21);
        priorityQueue1.offer(32);
        priorityQueue1.offer(20);
        priorityQueue1.offer(43);
        priorityQueue1.offer(31);

        System.out.println(priorityQueue1.peek());
    }

}
