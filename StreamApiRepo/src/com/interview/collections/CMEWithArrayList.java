package com.interview.collections;// File: CMEWithArrayList.java
import java.util.*;
public class CMEWithArrayList {
    public static void main(String[] args) throws InterruptedException {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) list.add(i);

        Thread iterator = new Thread(() -> {
            try {
                for (Integer x : list) {           // uses iterator internally
                    System.out.println("Iterating: " + x);
                    try { Thread.sleep(200); } catch (InterruptedException ignored) {}
                }
            } catch (Exception e) {
                System.out.println("Iterator thread caught: " + e);
            }
        });

        Thread modifier = new Thread(() -> {
            try {
                Thread.sleep(300);
            } catch (InterruptedException ignored) {}
            list.add(99);    // structural modification during iteration
            System.out.println("Modifier thread added 99");
        });

        iterator.start();
        modifier.start();
        iterator.join();
        modifier.join();
        System.out.println("Final list: " + list);
    }
}
