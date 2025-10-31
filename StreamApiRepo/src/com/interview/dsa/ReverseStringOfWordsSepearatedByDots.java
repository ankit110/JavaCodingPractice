package com.interview.dsa;

class ReverseStringOfWordsSepearatedByDots {
    public String reverseWords(String s) {

        StringBuilder str = new StringBuilder();  // final reversed result
        StringBuilder word = new StringBuilder(); // temporary builder for each word
        int n = s.length() - 1;

        for (int i = n; i >= 0; i--) {
            char ch = s.charAt(i);

            if (ch == '.') {
                // reverse collected word and append
                str.append(word.reverse());
                str.append('.');
                word.setLength(0); // clear word builder
            } else {
                word.append(ch);
            }
        }

        // append the last word after the loop
        str.append(word.reverse());

        return str.toString().replaceAll("^\\.+", "")    // remove leading dots
            .replaceAll("\\.+$", "")    // remove trailing dots
            .replaceAll("\\.{2,}", "."); // replace multiple dots with one
    }
}
