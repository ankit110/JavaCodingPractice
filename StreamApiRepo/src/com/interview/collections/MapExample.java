package com.interview.collections;// A sample program to demonstrate Map.

// Here, you will see how you
// can add elements using Map
import java.util.*;

class MapExample {

    public static void main(String args[])
    {

        // Creating object for Map.
        Map<Integer, String> map
            = new HashMap<Integer, String>();

        // Adding Elements using Map.
        map.put(100, "Amit");
        map.put(101, "Vijay");
        map.put(102, "Rahul");

        // Elements can traverse in any order
        for (Map.Entry m : map.entrySet()) {
            System.out.println(m.getKey() + " "
                               + m.getValue());
        }
        
        map.forEach((k, v) -> System.out.println(k + " -> " + v));
    }
}