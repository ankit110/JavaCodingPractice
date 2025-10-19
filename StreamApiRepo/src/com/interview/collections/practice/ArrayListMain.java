package com.interview.collections.practice;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

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


    }

}
