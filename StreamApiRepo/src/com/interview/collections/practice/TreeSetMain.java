package com.interview.collections.practice;

import java.util.*;

public class TreeSetMain {

    public static void main(String[] args) {
        TreeSet<String> colors = new TreeSet<>(List.of("Red", "Blue", "Green", "Yellow"));

        System.out.println("Colors:- " + colors);

//----------------------Iterate over TreeSet-------------------------------

        Iterator<String> it = colors.iterator();

        System.out.println("----------using iterator----------");

        while(it.hasNext()) {
            String color = it.next();
            System.out.println("Color:- " + color);
        }

//        -----------Descending Iterator-------------

        Iterator<String> itReversed = colors.descendingIterator();
        System.out.println("-----------Reversed Iterator----------------");
        while(itReversed.hasNext()) {
            String color = itReversed.next();
            System.out.println("name:- " + color);
        }

        System.out.println("--------using for loop-----------");
        for(String color : colors) {
            System.out.println("Color:- " + color);
        }

//-----------------------Add all the elements of a specified tree set to another tree set-------------

        TreeSet<String> new_treeSet = new TreeSet<>(List.of("Black", "Violet", "Pink"));

        colors.addAll(new_treeSet);

        System.out.println("new_treeSet:- " + new_treeSet);

        System.out.println("Colors:- " + colors);

//---------------------------------Reverse TreeSet------------------------------

        TreeSet<String> navigableSet = (TreeSet<String>) colors.descendingSet();

        System.out.println("Reversed Colors:- " + navigableSet);

        System.out.println("First Element:- " + navigableSet.first());
        System.out.println("Last Element:- " + navigableSet.last());

//------------------------Clone TreeSet------------------
        TreeSet<String> newTreeSet = new TreeSet<>();
        newTreeSet = (TreeSet<String>) colors.clone();

        System.out.println("New TreeSet of Colors:-- " + newTreeSet);

        System.out.println("Size of the TreeSet:- " + newTreeSet.size());

        if(newTreeSet.equals(new_treeSet)) {
            System.out.println("Both are equal");
        } else {
            System.out.println("Not Equal.");
        }

        TreeSet<Integer> numbers = new TreeSet<>(List.of(1, 4, 3, 6, 9, 7, 2, 8, 10));

        System.out.println("Numbers:- " + numbers);

        SortedSet<Integer> numbersLessThan7 = numbers.headSet(7);

        System.out.println("Numbers less than 7:- " + numbersLessThan7);
    }
}
