package com.interview.collections.practice;

import java.util.*;

public class PriorityQueueMain {

    public static void main(String[] args) {
        PriorityQueue<String> queue = new PriorityQueue<>(List.of("Red", "Blue", "White", "Green"));

        System.out.println("Queue:- " + queue);

//----------------------------Iterate over queue--------------------
        System.out.println("----------------Iterate using Iterator------------");
        Iterator<String> it = queue.iterator();

        while(it.hasNext()) {
            String color = it.next();
            System.out.println("color:- " + color);
        }

        System.out.println("---------------Using for loop-----------------");

        for (String color : queue) {
            System.out.println("Color:- " + color);
        }

//-------------Add all Elements in another Priority Queue--------------

        PriorityQueue<String> newQueue = new PriorityQueue<>(queue);

        System.out.println("New Queue:- " + newQueue);

        newQueue.addAll(queue);

        System.out.println("New Queue using addAll:- " + newQueue);

        queue.offer("Black");

        System.out.println("Queue:- " + queue);

        newQueue.clear();

        System.out.println("New queue after removing:- " + newQueue);

        int count = queue.size();

        System.out.println("Size:- " + count);

        newQueue.offer("Black");
        newQueue.offer("Red");
        newQueue.offer("White");
        newQueue.add("Pink");
        newQueue.add("Violet");

        PriorityQueue<String> containsQueue = new PriorityQueue<>();

        for(String color: newQueue) {
            containsQueue.add(queue.contains(color) ? "Yes" : "No");
        }

        System.out.println("Contains Queue:- " + containsQueue);

//----------------------------Priority Queue first Element------------------------
        System.out.println("First Element of Queue:- " + queue.peek());
        System.out.println("Queue:- " + queue);
//------------------------Retrieve first element and remove this----------------

        String pollElement = queue.poll();

        System.out.println("Poll Element:- " + pollElement);

        System.out.println("Queue:- " + queue);

//-------------------Convert Priority Queue to ArrayList-----------------------

        List<String> list = new ArrayList<>(queue);

        System.out.println("List:- " + list);
//--------------Convert it to String---------------------
        String str = queue.toString();

        System.out.println("String Representation:- " + str);
//----------------------Max Priority Queue------------------------

        PriorityQueue<String> maxQueue = new PriorityQueue<>(Comparator.reverseOrder());
        maxQueue.addAll(queue);

        System.out.println("Max Queue:- " + maxQueue);
    }
}
