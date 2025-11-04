package com.interview.dsa;

/*
*  Given two strings s and part, perform the following operation on s until all occurrences of the substring part are removed:

Find the leftmost occurrence of the substring part and remove it from s.
Return s after removing all occurrences of part.

A substring is a contiguous sequence of characters in a string.



Example 1:

Input: s = "daabcbaabcbc", part = "abc"
Output: "dab"
* */
class RemoveOccurrences {
    public String removeOccurrences(String s, String part) {
        StringBuilder sb = new StringBuilder();
        int len = s.length();

        int m = part.length();

        for(int i = 0; i < len; i++) {
            sb.append(s.charAt(i));

            if(sb.length() >= m) {
                boolean match = true;

                for(int j = 0; j < m; j++) {
                    if(sb.charAt(sb.length() - m + j) != part.charAt(j)) {
                        match = false;
                        break;
                    }
                }

                if(match) {
                    sb.setLength(sb.length() - m);
                }
            }
        }

        return sb.toString();
    }
}