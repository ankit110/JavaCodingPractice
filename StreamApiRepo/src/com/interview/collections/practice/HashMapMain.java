package com.interview.collections.practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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
        HashMap<Integer, String> mapCopy = new HashMap<>(map); // Shallow copy(Creates new buckets, copies same references)
        System.out.println("Map:- " + map);
        System.out.println("Copy Map:- " + mapCopy);

//| Operation             |         Description                         | Copy Type | Shared References? |
//| --------------------- | ------------------------------------------- | --------- | ------------------ |
//| `new HashMap<>(map1)` | Creates new buckets, copies same references | Shallow   | ✅ Yes              |
//| `clone()`             | Same as above                               | Shallow   | ✅ Yes              |
//| `putAll()`            | Copies same references into another map     | Shallow   | ✅ Yes              |
//| Deep Copy             | Creates **new objects** for each value      | ❌ No      | ❌ No               |

        mapCopy.replace(1, "Pink"); // It does not modify the existing object.
//It updates the reference in that map to point to a new object.
//        After replace operation both map and copyMap is pointing different object

        System.out.println("Map after updating in mapCopy:- " + map);
        System.out.println("Copy Map after updating in mapCopy:- " + mapCopy);

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

//--------------Get Shallow Copy of HashMap----------------

        HashMap<Integer, String> shallowCopyMap = new HashMap<>();
        shallowCopyMap = (HashMap<Integer, String>) map.clone();

        System.out.println("Shallow Copy:- " + shallowCopyMap);

//-----------------------Check If Key Exists in Map---------------------
        if(map.containsKey(3)) {
            System.out.println("Key exists in the Map" + map);
        } else {
            System.out.println("Key does not exists:- " + map);
        }

        if(map.containsKey("sdf")) {
            System.out.println("Key exists in the map:- " + map);
        } else {
            System.out.println("Key does not exists:- " + map);
        }

//------------------Check if Value Exists in Map--------------------------
        if(map.containsValue("Red")) {
            System.out.println("Value Exists in Map:- " + map);
        } else {
            System.out.println("Value does not exists:- " + map);
        }

        if(map.containsValue("Orange")) {
            System.out.println("Value Exists in Map:- " + map);
        } else {
            System.out.println("Value Does not exists:- " + map);
        }

//-------------------------Get Set View of Map Entries-----------------
        shallowCopyMap.put(5, "White");
        System.out.println("ShallowCopy:- " + shallowCopyMap);

        Set set = shallowCopyMap.entrySet();
        System.out.println("Set view:- " + set);

        String val = shallowCopyMap.get(4);

        System.out.println("Value for key 4:- " + val);
        System.out.println("Value:- " + shallowCopyMap.get(6));

        Set keys = shallowCopyMap.keySet();
        System.out.println("Keyset for shallowCopy:- " + keys);

        System.out.println("Values from Map:- " + map.values());
    }
}
