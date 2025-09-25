package exception;

import exception.interview.ParseInteger;

public class ExceptionMain {

    public static void main(String[] args) {

        ParseInteger parseInteger = new ParseInteger();

        System.out.println(parseInteger.parseInteger("abcd"));
    }
}
