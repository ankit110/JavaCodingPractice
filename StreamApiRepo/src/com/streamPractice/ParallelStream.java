package com.streamPractice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ParallelStream {

    public static void main(String[] args) {

        List<Integer> numbers
            = Arrays.asList(12,121,2312312,124,312431241,124141,24312,43124123,1241,241);

        Stream<Integer> parallelStream = numbers.parallelStream();

        Integer sumNumbers = parallelStream.reduce(0, (a, b) -> a + b);

        System.out.println(sumNumbers);

        // Another way

        Stream<Integer> parallelStreamMapToInt = numbers.parallelStream();

        Integer sumOfAllNumbers = parallelStreamMapToInt
            .mapToInt(a -> a) // or methodReference (Integer::intValue)
            .sum();

        System.out.println(sumOfAllNumbers);
    }
}
