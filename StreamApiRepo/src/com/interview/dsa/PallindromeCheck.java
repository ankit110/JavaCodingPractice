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

//---------------------------Using String Builder---------------------------------

       /* StringBuilder str = new StringBuilder();

        for(int i = 0; i < s.length(); i++) {
            if (Character.isLetterOrDigit(s.charAt(i))) {
                str.append(Character.toLowerCase(s.charAt(i)));
            }
        }

        int i = 0;
        int j = str.length() - 1;

        while(i <= j) {
            if(str.charAt(i) != str.charAt(j)) {
                return false;
            }

            i++;
            j--;
        }

        return true; */

//--------------------------Without using any Extra space SpaceComplexity -> O(1)--------------------

       /* int l = 0, r = s.length()-1;
        while(l<r) {
            // Move left pointer until we find a letter or digit
            while(l<r && !Character.isLetterOrDigit(s.charAt(l))) l++;
            // Move right pointer until we find a letter or digit
            while(l<r && !Character.isLetterOrDigit(s.charAt(r))) r--;
            // Compare both chars (in lowercase)
            if(Character.toLowerCase(s.charAt(l++)) != Character.toLowerCase(s.charAt(r--))) return false;
        }
        return true; */
    }

}