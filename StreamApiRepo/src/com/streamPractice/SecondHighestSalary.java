package com.streamPractice;

import com.streamPractice.model.Employee;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SecondHighestSalary {

    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
            new Employee(1, "Alice", 70000, "IT"),
            new Employee(2, "Bob", 85000, "Finance"),
            new Employee(3, "Charlie", 60000, "HR"),
            new Employee(4, "David", 75000, "IT"),
            new Employee(5, "Eve", 90000, "Finance"),
            new Employee(6, "Reacher", 90000, "Finance"),
            new Employee(7, "Frank", 50000, "HR")
        );

        Stream<Employee> employeeStream = employees.stream();

        List<Double> salaryList = employeeStream.map(e -> e.getSalary())
            .sorted(Comparator.reverseOrder())
            .distinct()
            .collect(Collectors.toList());

        System.out.println(salaryList.get(1));

        employees.stream()
            .map(Employee::getSalary)
            .distinct()
            .sorted(Comparator.reverseOrder())
            .skip(1)
            .findFirst()
            .ifPresent(System.out::println); // 2nd highest salary

        int N = 3; // 3rd highest
        employees.stream()
            .map(Employee::getSalary)
            .distinct()
            .sorted(Comparator.reverseOrder())
            .skip(N - 1)
            .findFirst()
            .ifPresent(System.out::println); // For n-th the highest salary


    }
}
