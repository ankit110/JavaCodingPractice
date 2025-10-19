package com.interview.collections.practice;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArrayListMain {

    public static void main(String[] args) {
        List<String> list = ArrayListPractice.list;
        System.out.println(ArrayListPractice.list);

//  ---------------------Iterating using For each loop-------------------
        System.out.println("-------using For each loop---------------");
        for(String element : list) {
            System.out.println(element);
        }

//-----------------------Iterating using Iterator-----------------------
        System.out.println("--------Using Iterator-------------------");
        Iterator<String> it = list.iterator();

        while(it.hasNext()) {
            System.out.println(it.next());
        }

//-----------------Insert at first position---------------------------
        System.out.println("---------Inserting element at first position-------");

        list.add(0, "Orange");
        System.out.println(list);
//---------------------Retrieve Element by Index----------------------
        System.out.println(list.get(4));
//---------------------update List Element----------------------------
        System.out.println("------Update the Element-----------");
        System.out.println(list.set(6, "Green"));
        System.out.println(list);

//--------------------Remove Third Element-----------------------------
        System.out.println("---Remove Third Element----");

        list.remove(2);
        System.out.println(list);
//-------------------Search Element in Array(Find Black)---------------------------
        if(list.contains("Black")) {
            System.out.println("Element found.");
        } else {
            System.out.println("Element Not Found.");
        }
//-------------------Sort ArrayList---------------------------
        Collections.sort(list);
        System.out.println("Sort using Collections:- " + list);
        list.sort(Comparator.naturalOrder());
        System.out.println("Natural Order:- " + list);
        list.sort(Comparator.reverseOrder());
        System.out.println("Reverse Order:- " + list);

        list.sort(String.CASE_INSENSITIVE_ORDER);
        System.out.println("Case Insensitive Order:- " + list);

        list.sort(Comparator.comparing(String::length));
        System.out.println("Sort using length:- " + list);

//----------------Copy One Arraylist to another---------------------
        List<String> list1 = new ArrayList<>();
        list1.add("A");
        System.out.println("List1:- " + list1);
        Collections.copy(list, list1);
        System.out.println("List1:- " + list1);
        System.out.println("Copied List:- " + list);
        Collections.copy(list, List.of("Red"));
        System.out.println("List:- " + list);

//--------------------Shuffle Arraylist-------------------------------
        Collections.shuffle(list);
        System.out.println("Shuffled List:- " + list);
//---------------------Reverse ArrayList------------------------
        Collections.reverse(list);
        System.out.println("Reversed Array:- " + list);

//--------------------Extract Sublist from ArrayList----------------
        List<String> sub_list = list.subList(0, 2);
        System.out.println("Sublist:- " + sub_list);
        System.out.println("List:- " + list);
//-----------------------Rotate List------------------
/*        Collections.rotate(list, distance) shifts the elements.
          Positive value → rotate to right.
          Negative value → rotate to left.
          -2 means shift everything 2 places left (start from index 2). */

        //----------------Rotate Left----------------
        Collections.rotate(list, -2);
        System.out.println("Rotated List to left:- " + list);

        Collections.rotate(list, 2);
        System.out.println("Rotated List to Right:- " + list);

        //---------------Using Streams-----------------
        int rotateBy = 2;

        List<String> rotated = Stream.concat(
            list.stream().skip(rotateBy),  // skip first 2 elements
            list.stream().limit(rotateBy)  // take first 2 elements and put at the end
        ).collect(Collectors.toList());

        System.out.println(rotated);

    }

}
