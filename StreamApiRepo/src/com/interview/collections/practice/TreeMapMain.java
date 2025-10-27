package com.interview.collections.practice;

import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapMain {

    public static void main(String[] args) {
        TreeMap<Integer, String> map = new TreeMap<>(Map.of(
            1, "Red",
            2, "White",
            3, "Green",
            4, "Black"
        ));

        System.out.println("Tree Map:- " + map);

        System.out.println("Map keys and Value --->");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println("Key=> " + entry.getKey() + ", Value=> " + entry.getValue());
        }

        TreeMap<Integer, String> copyMap = new TreeMap<>();

        copyMap.putAll(map);

        System.out.println("Copy Map keys and Value --->");
        for(Map.Entry<Integer, String> entry : copyMap.entrySet()) {
            System.out.println("Key=> " + entry.getKey() + ", Value=> " + entry.getValue());
        }

//---------------------------Search Keys / Values--------------
        if(map.containsKey(2)) {
            System.out.println("Found key 2");
        } else {
            System.out.println("Not Found key 2");
        }

        if(map.containsKey(5)) {
            System.out.println("Found Key 5");
        } else {
            System.out.println("Not Found key 5");
        }

        if(map.containsValue("Green")) {
            System.out.println("Value found:- Green");
        } else {
            System.out.println("Value not found:- Green");
        }

        if (map.containsValue("Pink")) {
            System.out.println("Pink Found");
        } else {
            System.out.println("Pink not found");
        }

//--------------------Get All Keys---------------------

        Set<Integer> keys = map.keySet();

        System.out.println("Keys:- " + keys);

//----------------------Delete All Elements----------------
        copyMap.clear();
        System.out.println("CopyMap:- " + copyMap);

//------------------------Sort Map-------------------
        TreeMap<String, String> sortMap = new TreeMap<>(new SortKey());

        sortMap.put("C1", "Red");
        sortMap.put("C4", "White");
        sortMap.put("C2", "Black");
        sortMap.put("C3", "Blue");

        System.out.println("Sorted Map:- " + sortMap);

//----------------------Get Mapping with Greatest and Least Key------------------------
        System.out.println("Greatest Key Entry:- " + map.firstEntry());
        System.out.println("Least Key Entry:- " + map.lastEntry());
//----------------------Get First and Last Key in TreeMap----------------------------
        System.out.println("Greatest Key:- " + map.firstEntry());
        System.out.println("Least Key:- " + map.lastEntry());
//-----------------------Get Reverse View of TreeMap Keys-------------------------
        System.out.println("Reverse view for Keyset:- " + map.descendingKeySet());
    }
}

class SortKey implements Comparator<String> {
    @Override
    public int compare(String str1, String str2) {
        return -str1.compareTo(str2);
    }
}
