package com.interview.dsa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortAndMergeTwoArrays {

    public static ArrayList<Integer> sortArrays(ArrayList<Integer> arr1, ArrayList<Integer> arr2) {
        ArrayList<Integer> result = new ArrayList<>();

        Collections.sort(arr1);
        Collections.sort(arr2);

        int n = arr1.size() - 1;
        int m = arr2.size() - 1;

        int i = 0;
        int j = 0;

        while(i <= n && j <= m) {
            if(arr1.get(i) < arr2.get(j)) {
                result.add(arr1.get(i));
                i++;
            } else {
                result.add(arr2.get(j));
                j++;
            }
        }

        while(i <= n) {
            result.add(arr1.get(i));
            i++;
        }

        while(j <= m) {
            result.add(arr2.get(j));
            j++;
        }
        return result;
    }

}

class MergeMain {
    public static void main(String[] args) {
        ArrayList<Integer> arr1 = new ArrayList<>(List.of(3, 2, 5, 4, 1));
        ArrayList<Integer> arr2 = new ArrayList<>(List.of(8, 7, 5, 4, 10, 6, 9));

        ArrayList<Integer> arrRes = SortAndMergeTwoArrays.sortArrays(arr1, arr2);

        System.out.println(arrRes);
    }
}
