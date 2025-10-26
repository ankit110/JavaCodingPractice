package com.interview.collections.practice;

import java.util.HashMap;
import java.util.Map;

public class HashMapMain {

    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>(Map.of(1, "Red",
            2, "Black",
            3, "White",
            4, "Green"));

        System.out.println("Map:- " + map);
//---------------Iterate over Map------------------
        for(Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println("Key:- " + entry.getKey() + " Value:- " + entry.getValue());
        }
//---------------------Size of the Map------------------------
        System.out.println("Size of the Map:- " + map.size());
//--------------------Copy one Map to Another--------------------------
        HashMap<Integer, String> mapCopy = new HashMap<>(map);
        System.out.println("Copy Map:- " + mapCopy);
//----------------------Clear Map---------
        mapCopy.clear();
        System.out.println("Copy Map after removing all Elements:- " + mapCopy);

//-----------------------Check if Empty------------------------

        if(map.isEmpty()) {
            System.out.println("Map is Empty." + map);
        } else {
            System.out.println("Map is not Empty." + map);
        }

        if(mapCopy.isEmpty()) {
            System.out.println("copyMap is Empty" + mapCopy);
        } else {
            System.out.println("copyMap is not Empty." + mapCopy);
        }
    }
}
