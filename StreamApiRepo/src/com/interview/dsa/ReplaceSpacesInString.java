package com.interview.dsa;

import java.util.*;
import java.io.*;

public class ReplaceSpacesInString {
    public static StringBuilder replaceSpaces(StringBuilder str) {
        // Write your code here.

        // for(int i = 0; i < str.length(); i++) {
        // 	if(str.charAt(i) == ' ') {

        // 		str.replace(i, i+1, "@40");
        // 		i = i+2;
        // 	}
        // }


        // return str;

        StringBuilder res = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                res.append("@40");
            } else {
                res.append(str.charAt(i));
            }
        }

        return res;

    }
}