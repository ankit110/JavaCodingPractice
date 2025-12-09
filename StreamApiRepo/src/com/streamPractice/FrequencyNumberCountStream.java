package com.streamPractice;

import org.w3c.dom.ls.LSOutput;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FrequencyNumberCountStream {
    public static void main(String[] args) {
        List<Integer> list = List.of(9, 8, 4, 9, 5, 4, 9, 1);

        Map<Integer, Long> freqMap = list.stream()
            .collect(Collectors.groupingBy(n -> n, Collectors.counting()));

        freqMap.forEach((k, v) -> System.out.println(k + " = " + v));
    }
}
