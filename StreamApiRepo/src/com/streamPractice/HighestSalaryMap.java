package com.streamPractice;

import java.util.*;

public class HighestSalaryMap {

    public static void main(String[] args) {

        Map<String, List<Integer>> salaryMap = new HashMap<>();

        salaryMap.put("IT", Arrays.asList(70000, 71999, 77000, 50000));
        salaryMap.put("HR", Arrays.asList(46000, 57000, 73000));
        salaryMap.put("Finance", Arrays.asList(87000, 32000, 49000));

        List<Integer> salaryGreaterThanSeventy = salaryMap.values()
            .stream().flatMap(List::stream)
            .filter(salary -> salary > 70000)
            .sorted(Comparator.comparingDouble(salary -> salary))
            .toList();

        System.out.println(salaryGreaterThanSeventy);
    }
}
