package com.interview.dsa;

import java.util.ArrayList;
import java.util.List;

public class ReverseArray {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>(List.of(1, 3, 5, 4, 10, 6, 7, 8, 9));

        System.out.println(numbers);

        int i = 0;
        int j = numbers.size() - 1;

        while(i <= j) {
            swap(numbers, i, j);
            i++;
            j--;
        }

        System.out.println(numbers);
    }

    private static void swap(ArrayList<Integer> numbers, int i, int j) {

        int temp = numbers.get(i);
        numbers.set(i, numbers.get(j));
        numbers.set(j, temp);

    }
}
