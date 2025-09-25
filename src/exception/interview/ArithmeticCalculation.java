package exception.interview;

import exception.customexceptionclasses.DivisionByZeroException;

public class ArithmeticCalculation {

    public static double divide(int a, int b) throws DivisionByZeroException {

        if(b == 0) {
            throw new DivisionByZeroException("Cannot Divide Zero.");
        }
        return (double) a/b;
    }
}
