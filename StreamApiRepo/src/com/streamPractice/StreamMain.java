package com.streamPractice;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMain {

    public static void main(String args[]) {
        // Q) Create a list and filter the even elements from the list with and without srteam.

        // Create a list

        List<Integer> listOfIntegers = List.of(1, 2, 3, 4, 545,3453, 2, 342, 65, 234); // This list is immutable you can't modify it later once it is declared you will get UnsupportedOperationException.

        List<Integer> listOfIntegers1 = new ArrayList<Integer>();

        List<Integer> listOfInteger2 = Arrays.asList(2, 3,4,45,5,55,5,534, 3, 2, 23, 12, 311,12,321,332);


        List<Integer> evenInteger = new ArrayList<>();

        // Without Stream

        for(int i : listOfIntegers) {
            if((i & 1) == 0) {
                evenInteger.add(i);
            }
        }
        System.out.println(listOfIntegers);

        System.out.println(evenInteger);

        // Using StreamApi

        Stream<Integer> streamList = listOfIntegers.stream();  // You can only use this variable one time.

        List<Integer> filteredEvenInteger = streamList.filter(i -> (i&1) == 0).collect(Collectors.toList());

        System.out.println("filteredEvenInteger: " + filteredEvenInteger);

        List<Integer> numberGreaterThanTen = listOfIntegers.stream().filter(i -> {
            return (i > 10);
        }).collect(Collectors.toList());

        List<Integer> numberGreaterThanTen1 = listOfInteger2.stream().filter(i -> (i > 10)).collect(Collectors.toList());

        System.out.println("numberGreaterThanTen: " + numberGreaterThanTen);

        System.out.println("Number is greater than Ten: " + numberGreaterThanTen1);
    }

}
