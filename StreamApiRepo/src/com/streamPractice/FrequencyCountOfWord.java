package com.streamPractice;


import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/* Q2. You are given a list of strings:
["apple", "banana", "mango", "apple", "orange", "banana"]

Write Java 8 code to:

Find the frequency (count) of each word.

Print the result as a Map<String, Long>.

👉 (Hint: Think about Collectors.groupingBy) */
public class FrequencyCountOfWord {

    public static void main(String[] args) {
        List<String> fruitsList = List.of("apple", "banana", "mango", "apple", "orange", "banana");

        Stream<String> listStream = fruitsList.stream();

        Map<String, Long> getFruitsList = listStream.collect(Collectors.groupingBy(fruit ->
            fruit,Collectors.counting()
        ));

        System.out.println(getFruitsList);
    }


}
