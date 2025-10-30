package com.interview.dsa;

import java.util.*;
import java.io.*;

public class PallindromeCheck {

    public static boolean checkPalindrome(String str) {

        // WRITE YOUR CODE HERE
        ArrayList<Character> array = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {
            if ((str.charAt(i) >= 48 && str.charAt(i) <= 57) || (str.charAt(i) >= 65 && str.charAt(i) <= 90) || (str.charAt(i) >= 97 && str.charAt(i) <= 122)) {
                if (Character.isLetter(str.charAt(i))) {
                    array.add(Character.toLowerCase(str.charAt(i)));
                } else {
                    array.add(str.charAt(i));
                }

            }
        }

        int i = 0;
        int j = array.size() - 1;

        while (i <= j) {
            if (array.get(i) != array.get(j)) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }

}