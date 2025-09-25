package exception;

import exception.customexceptionclasses.DivisionByZeroException;
import exception.customexceptionclasses.InvalidAgeException;
import exception.interview.AgeValidation;
import exception.interview.ArithmeticCalculation;
import exception.interview.ParseInteger;

// custom exception chaining and logging.

public class CheckedAndUncheckedExceptionMain {

    public static void main(String[] args) {

        ParseInteger parseInteger = new ParseInteger();
//
        System.out.println(parseInteger.parseInteger("abcd"));
//-------------------------------------------------------------------------------------
//        Checked Exception :- Compiler force you to must handle this exception.
//        ---------------------------------------------------------------------------------

        try {
            double res = ArithmeticCalculation.divide(5, 0);
            System.out.println(res);
        } catch (DivisionByZeroException ex) {
            System.out.println("Exception Caught:- " + ex.getMessage());
        }

//        double res = ArithmeticCalculation.divide(5, 0); // Unhandled exception:
        // exception.customexceptionclasses.DivisionByZeroException
//   -----------------------------------------------------------------------------------------------------------

//        Unchecked Exception:- 🟡 Java does not force you to handle unchecked exceptions.
//        You can catch them if you want, but it's optional.
        try {
            String res = AgeValidation.validateAge(17);
            System.out.println(res);
        } catch(InvalidAgeException ex) {
            System.out.println("Access Denied: " + ex.getMessage());
        }

//        // ✅ This compiles fine even without try-catch

//        String res = AgeValidation.validateAge(17); // Exception in thread "main"
        // exception.customexceptionclasses.InvalidAgeException: Age must be 18 or above.

    }
}
