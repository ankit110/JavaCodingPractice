package com.interview.dsa;

import java.util.ArrayList;
import java.util.List;

public class SecondSmallestAndLargest {
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>(List.of(1,2, 3, 4, 5,6, 8, 7, 22, 11, 17));
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        for( int num : nums) {
            if(num < min1) {
                min2 = min1;
                min1 = num;
            } else if(num < min2 && num != min1) {
                min2 = num;
            }

            if(num > max1) {
                max2 = max1;
                max1 = num;
            } else if(num > max2 && num != max1) {
                max2 = num;
            }
        }

        System.out.println("Min1 :- " + min1 + " Max1:- " + max1);
        System.out.println("Min2:- " + min2 + " Max2:- " + max2);
    }
}
