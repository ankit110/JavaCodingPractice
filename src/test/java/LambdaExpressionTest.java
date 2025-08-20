package test.java;


import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class LambdaExpressionTest {

    @Test
    public void sumOfOddNumbers_usual() {
        List<Integer> numbers = Arrays.asList(2, 3, 5, 7, 9, 12, 24, 1);

        int sum = 0; // state of sum - 0

        for(int number : numbers) {
            if((number & 1) != 0)
                sum += number; // state of sum - 3, 8, 15, 24, 25 ( here changes in state)
            // so due to changes in state here during multithreading it can be a big problem or may throw error .
        }

        assertEquals(25, sum);

    }

    // No changes to state
    @Test
    public void sumOfOddNumbers_FunctionalProgramming() {
        List<Integer> numbers = Arrays.asList(2, 3, 5, 7, 9, 12, 24, 1);

        int sum = numbers.stream() // create stream
                .filter(number -> (number&1) != 0) // Intermediate Operation
                .reduce(0, Integer::sum);  // Terminal Operation

        assertEquals(25, sum);

        // Functional is a style of programming where we use lambda expressions and streams
        // to make sure that our code does not have any state.

        // in filter, we separate the odd values first and then sum these all values in reduce function
        // so there no state for sum variable.

//        number -> (number&1) != 0 --> Lambda expression
//        Integer::sum --> Method Reference


        // so we go for Functional Programming and write codes which does not have state then we would be able
        // to scale them up very easily, so we can run them in multiple threads very easily.
        // that's the main advantage of functional programming

    }
}
