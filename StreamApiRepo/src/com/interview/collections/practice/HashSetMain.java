package com.interview.collections.practice;

import java.util.*;

public class HashSetMain {

    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>(List.of("Ankit", "Ayush", "Abhijeet", "Manish", "Ankit"));

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
//---------------------Clear HashSet-----------------------------------

        HashSet<String> setCopy = new HashSet<>(set);


        System.out.println("setCopy:- " + setCopy);
        setCopy.clear();
        System.out.println("setCopy:- " + setCopy);

        HashSet setClone = (HashSet) set.clone();
        System.out.println("setClone:- " + setClone);
        setCopy.clear();
        System.out.println("setClone:- " + setClone);
        setClone.add("Abhay");
//---------------------Convert Hashset to Array----------------------------

        List<String> list = new ArrayList<>(set);

        System.out.println("List:- " + list);

        List<String> newList = new ArrayList<>();
        newList.addAll(set);

        System.out.println("New List:- " + newList);

        String[] array = new String[set.size()];
        set.toArray(array);

        System.out.println("Array:- " + array);
        System.out.println("Array Elements-> ");

        for(String name : array) {
            System.out.println("Name in Array:- " + name);
        }

//--------------------------HashSet to TreeSet-------------------

        TreeSet<String> treeSet = new TreeSet<>(set);

        System.out.println("TreeSet:- " + treeSet);

//        -----------------Less Than 7--------------------
        TreeSet<Integer> integerTreeSet = new TreeSet<>(List.of(4, 2, 3, 8, 6, 7, 1, 9));

        System.out.println("Integer Tree Set:- " + integerTreeSet);
        SortedSet<Integer> sortedSet = integerTreeSet.headSet(7);

        System.out.println("Integers Less than 7:- " + sortedSet);

        Integer lowerThan7 = integerTreeSet.lower(7);

        System.out.println("Lower than 7:- " + lowerThan7);

//---------------------------Compare two HashSet--------------

        List<Boolean> booleanHashset = new ArrayList<>(set.size());

        System.out.println("Set:- " + set);
        HashSet<String> newHashSet = new HashSet<>(set);
        newHashSet.remove("Prashant");
        newHashSet.add("Abhay");

        for(String name : set) {
            booleanHashset.add(newHashSet.contains(name) ? true : false);
        }

        System.out.println("New HashSet:- " + booleanHashset);
//--------------------------RetainAll------------------------

        System.out.println("----------RetainAll-----------");
        set.retainAll(newHashSet);
        System.out.println("Set:- " + set);
        System.out.println("New Hash Set:- " + newHashSet);

//-------------------Remove All--------------
        newHashSet.clear();

        System.out.println("----------Remove all--------");
        System.out.println("New hash Set after removal:- " + newHashSet);
    }
}
