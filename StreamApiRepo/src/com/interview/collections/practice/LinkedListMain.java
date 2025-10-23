package com.interview.collections.practice;

import java.util.*;

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
//-----------------remove and return the first element-----------------------
        System.out.println("Removed first element:- " + new_lists.pop());

        System.out.println("New Lists after pop() operation:- " + new_lists);
//------------retrieve, but not remove, the first element------------------------
        System.out.println("Return First Element:- " + new_lists.peek());
        System.out.println("Return First Element:- " + new_lists.peekFirst());
        System.out.println("Return Last Element:- " + new_lists.peekLast());
        System.out.println(new_lists);
//-------------------check if a particular element exists-----------------------
        if(new_lists.contains("Avinash")) {
            System.out.println("Object Found in List.");
        } else {
            System.out.println("Object Not Found in List.");
        }

//---------------- convert a linked list to an array list-------------------------

        List<String> arrayList = new ArrayList<>(list);
        System.out.println("Converted ArrayList using linkedList passed in Constructor:- " + arrayList);

        arrayList.clear();

        arrayList.addAll(list);

        System.out.println("Converted ArrayList using addAll method:- " + arrayList);

//--------------------Compare two LinkedList-------------
        LinkedList<Boolean> comparedListElement = new LinkedList<>();

        for(String name: list) {
            comparedListElement.add(new_list.contains(name) ? true : false);
        }

        System.out.println(list);
        System.out.println(new_list);
        System.out.println(comparedListElement);

//----------------check if a linked list is empty or not------------------------------

        if(list.isEmpty()) {
            System.out.println("List is empty.");
        } else {
            System.out.println("List is not Empty.");
        }

//-----------------replace an element in a linked list-------------------

        new_list.set(0, "Ankit");
        System.out.println("New List:- " + new_list);

    }
}
