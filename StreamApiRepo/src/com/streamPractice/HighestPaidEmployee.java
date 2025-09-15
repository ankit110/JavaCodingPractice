package com.streamPractice;

import com.streamPractice.model.Employee;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/* You are given a list of employees.
👉 Write Java 8 code to find the name of the highest-paid employee across all departments.

Return it as Optional<String>. */

public class HighestPaidEmployee {

    public static void main(String[] args) {
        List<Employee> employeeList = Arrays.asList(
            new Employee(2, "Alice", 70000, "IT"),
            new Employee(3, "Bob", 60000, "HR"),
            new Employee(4, "Charlie", 80000, "HR"),
            new Employee(5, "David", 75000, "Finance"),
            new Employee(6, "Alex", 77000, "Finance")
        );

        Stream<Employee> employeeStream = employeeList.stream();

        Optional<String> highestSalaryEmployee = employeeStream
            .max(Comparator.comparingDouble(Employee::getSalary)) // find max employee by salary
            .map(Employee::getName); // max salary returned mapped to name

        System.out.println(highestSalaryEmployee);
    }
}
