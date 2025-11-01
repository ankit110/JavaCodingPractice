package com.interview.dsa;

class SmallAlphabetCharFreq {
    public char getMaxOccuringChar(String s) {
        // code here

        int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        int max = -1;
        char res = 'a';

        for (int i = 0; i < 26; i++) {
            if (max < freq[i]) {
                max = freq[i];
                res = (char) (i + 'a');
            }
        }

        return res;

    }
}