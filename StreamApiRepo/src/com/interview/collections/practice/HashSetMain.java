package com.interview.collections.practice;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class HashSetMain {

    public static void main(String[] args) {
        Set<String> set = new HashSet<>(List.of("Ankit", "Ayush", "Abhijeet", "Manish", "Ankit"));

        System.out.println("Set:- " + set);
//---------------------Append Element--------------------
        set.add("Prashant");
        System.out.println("Set:- " + set);

//-------------------------Iterate over hashset----------------------
        Iterator<String> it = set.iterator();

        while(it.hasNext()) {
            String name = it.next();

            System.out.println("name:- " + name);
        }

        System.out.println("------------------Iterating using for each loop-------------------");

        for(String name : set) {
            System.out.println("Name:- " + name);
        }

//---------------------------Get the Size------------------------------

        System.out.println("Size of the Set:- " + set.size());
    }
}
