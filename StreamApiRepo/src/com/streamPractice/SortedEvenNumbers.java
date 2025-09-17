package com.streamPractice;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
Q1. Given a list of integers, write Java 8 code to:

Find all even numbers,

Multiply them by 2,

Collect them into a list,

And print the result in sorted order.
  */

public class SortedEvenNumbers {

    public static void main(String[] args) {
        List<Integer> listNumbers = new ArrayList<>();
        listNumbers.add(13);
        listNumbers.add(12);
        listNumbers.add(43);
        listNumbers.add(45);
        listNumbers.add(42);
        listNumbers.add(86);

        Stream<Integer> integerStream = listNumbers.stream();

       /* List<Integer> sortedEvenNumbers = integerStream
            .filter(number -> (number&1) == 0)
            .collect(Collectors.toList());
        
        for(int i = 0; i < sortedEvenNumbers.size(); i++) {
            sortedEvenNumbers.set(i, sortedEvenNumbers.get(i)*2);
            // for this step I can use .map() here in Stream pipeline to map the numbers.
            // and then use sorted()
        }

        for(int number : sortedEvenNumbers) {
            System.out.println(number);
            // for this step I can use  forEach loop.
        } */
        
        List<Integer> sortedNumbers = integerStream
            .filter(number -> (number&1) == 0)
            .map(number -> number * 2)
            .sorted()
            .collect(Collectors.toList());

        sortedNumbers.forEach(System.out::println);
    }
}
