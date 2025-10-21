package com.interview.collections.practice;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LinkedListMain {

    public static void main(String[] args) {

        LinkedList<String> list = new LinkedList<>(List.of("Ankit", "Manish", "Ayush"));

        System.out.println("List:- " + list);
        list.add("Abhijeet");
        System.out.println("List after append operation:- " + list);
//-----------------------iterate through all element------------------
        System.out.println("------iterate over elements---------");
        for(String name : list) {
            System.out.println("Name using forEach loop:- " + name);
        }

//        ---------------------iterate using iterator--------------
        Iterator<String> it = list.iterator();

        while(it.hasNext()) {
            System.out.println("name using iterator:- " + it.next());
        }
//        ----------------Iterate list starting at the specified position--------------------
        Iterator<String> iterator = list.listIterator(2);

        while(iterator.hasNext()) {
            System.out.println("Name :-- " + iterator.next());
        }
//        --------------------Iterate in reverse order-------------------

        Iterator<String> reverseIterator = list.descendingIterator();

        while (reverseIterator.hasNext()) {
            System.out.println("Name:- " + reverseIterator.next());
        }
//------------------------Insert Element at specified position--------------------
        list.add(2, "Prashant");
        System.out.println("List:- " + list);
//        -------------Insert Element at First and Last position-------------------
        list.addFirst("Singh");
        System.out.println("Element inserted at First position:- " + list);

        list.addLast("Abhay");
        System.out.println("Element Inserted at Last Position:- " + list);
//        -------------------Insert Element at the Front----------------
        list.offerFirst("Robin");
        System.out.println("Element inserted in Front:- " + list);

//-----------------------Insert Some Elements at specified index-----------------

        LinkedList<String> new_list = new LinkedList<>(List.of("Kunal", "Ayush", "hrishikesh", "Avinash"));

        list.addAll(4, new_list);

        System.out.println("List After adding another List:- " + list);
//--------------------------- first and last occurrence of specific elements--------------------------
        int firstIndex = list.indexOf("Ayush");
        int lastIndex = list.lastIndexOf("Ayush");

        if(firstIndex != -1) {
            System.out.println("First Index of Ayush:- " + firstIndex);
            System.out.println("Last Index of Ayush:- " + lastIndex);
        } else {
            System.out.println("Not Found.");
        }

        for(int i = 0; i < list.size(); i++) {
            System.out.println("Name:- " + list.get(i) + " at index:- " + i);
        }
//----------------------Remove element------------------------
        System.out.println(list.remove("Singh"));
        System.out.println(list);

//----------------------Remove first and last Element---------------
        System.out.println(list.removeFirst());
        System.out.println(list);

        System.out.println(list.removeLast());
        System.out.println(list);

        LinkedList<String> new_lists = (LinkedList<String>) list.clone();

        System.out.println(new_lists);
        new_lists.clear();
        System.out.println(new_lists);
        System.out.println(list);
//-----------------------Swap Elements------------------------
        Collections.swap(list, 2, 4);
        System.out.println(list);

//------------------------Shuffle Elements---------------------
        Collections.shuffle(list);
        System.out.println(list);

//---------------------------Join two list-------------------
        new_lists = new LinkedList<>(List.of("Ravi", "Harsh", "Shailesh", "Avinash"));
        new_lists.addAll(list);

        System.out.println(new_lists);


    }
}
