package com.interview.dsa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FindingDuplicates {
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>(List.of(6, 2, 5, 6, 2, 1, 3, 1, 8, 3));

        ArrayList<Integer> res = new ArrayList<>();

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.size(); i++) {
            map.put(nums.get(i), map.getOrDefault(nums.get(i), 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() > 1) {
                res.add(entry.getKey());
            }
        }

        System.out.println(res);

        List<Integer> duplicates =
            map.entrySet()
                .stream()
                .filter(e -> e.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        System.out.println(duplicates);
    }
}
