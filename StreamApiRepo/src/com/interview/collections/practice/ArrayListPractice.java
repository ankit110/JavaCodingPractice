package com.interview.collections.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArrayListPractice {

    public static List<String> list = Stream.of("Red", "Blue","Black", "ankit", "white", "Yellow", "Pink", "Violet")
        .collect(Collectors.toList());

}
