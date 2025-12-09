package com.interview.dsa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrequencyNumberCount {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(List.of(9, 8, 4, 9, 5, 4, 9, 1));

        Map<Integer, Integer> map = new HashMap<>();

        for(int num : list) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
}
