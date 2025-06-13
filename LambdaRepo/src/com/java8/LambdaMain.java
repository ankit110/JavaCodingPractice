package com.java8;

import com.java8.lambdaPractice.LengthInterface;
import com.java8.lambdaPractice.MyInterface;
import com.java8.lambdaPractice.SumInterface;

public class LambdaMain {

    public static void main(String[] args) {

        // By using anonymous function

        MyInterface i1 = new MyInterface() {
            @Override
            public void sayHello() {
                System.out.println("This is the anonymous function");
            }
        };

        i1.sayHello();

        MyInterface i2 = new MyInterface() {
            @Override
            public void sayHello() {
                System.out.println("This is the second anonymous function");
            }
        };

        i2.sayHello();

        // By using lambda Expression

        MyInterface myInterface = () -> {
            System.out.println("This is the lambda expression.");
        };

        myInterface.sayHello();

//        -------------------------------SUM INTERFACE---------------------

        SumInterface sumInterface = (int a, int b) -> {
            return a + b;
        };

        System.out.println(sumInterface.sum(5, 7));

        SumInterface sumInterface1 = Integer::sum;

        System.out.println(sumInterface1.sum(345,2));

//        ----------------------------Length Interface------------------------

        LengthInterface lengthInterface = String::length;

        System.out.println(lengthInterface.lengthString("Ankit"));

        System.out.println("String length :- " + lengthInterface.lengthString("Ankit kumar"));
    }

}
