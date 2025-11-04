package com.interview.dsa;

import java.util.HashMap;
import java.util.Map;

public class ArbitraryCharsFreq {

    public char getMaxOccuringChar(String s) {
        Map<Character, Integer> freq = new HashMap<>();

        for (char ch : s.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        char result = '\0';
        int max = 0;

        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            if (entry.getValue() > max ||
                (entry.getValue() == max && entry.getKey() < result)) {
                max = entry.getValue();
                result = entry.getKey();
            }
        }

        return result;
    }


}
