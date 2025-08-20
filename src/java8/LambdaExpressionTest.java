package java8;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LambdaExpressionTest {

    @Test
    public void sumOfOddNumbers_usual() {
        List<Integer> numbers = Arrays.asList(2, 3, 5, 7, 9, 12, 24, 1);

        int sum = 0;

        for(int number : numbers) {
            if((number & 1) != 0)
                sum += number;
        }

        assertEquals(25, sum);

    }
}
