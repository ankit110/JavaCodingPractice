package com.streamPractice;

import com.streamPractice.model.Employee;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/* 👉 Now, next interview-style twist:

Write Java 8 code to find the employee(s) with the second-highest salary
(not just the salary value).

 */
public class SecondHighestSalariedEmployee {

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee(1, "Alice", 70000, "IT"),
            new Employee(2, "Bob", 85000, "Finance"),
            new Employee(3, "Charlie", 60000, "HR"),
            new Employee(4, "David", 75000, "IT"),
            new Employee(5, "Eve", 90000, "Finance"),
            new Employee(6, "Reacher", 90000, "Finance"),
            new Employee(7, "Frank", 50000, "HR"),
            new Employee(8, "Bob", 85000, "IT")
        );

        Stream<Employee> employeeStream = employees.stream();

        Double employeeSalary = employeeStream
            .map(Employee::getSalary)
            .distinct()
            .sorted(Comparator.reverseOrder())
            .skip(1)
            .findFirst().get();

        List<Employee> secondHighestSalaryEmployee = employees.stream()
            .filter(em -> em.getSalary() == employeeSalary)
            .collect(Collectors.toList());

        System.out.println(secondHighestSalaryEmployee);
    }

}
