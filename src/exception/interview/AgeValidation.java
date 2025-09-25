package exception.interview;

import exception.customexceptionclasses.InvalidAgeException;

public class AgeValidation {

    public static String validateAge(int age) {
        if(age < 18) {
            throw new InvalidAgeException("Age must be 18 or above.");
        }
        return "Valid Age";
    }
}
