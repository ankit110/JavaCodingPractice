package com.streamPractice;

import com.streamPractice.model.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/* Write Java 8 code to partition employees into two groups:

Employees earning more than 70,000

Employees earning less than or equal to 70,000

👉 The output should be a Map<Boolean, List<Employee>> */

public class PartitionEmployeeIntoTwoGroups {

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee(1, "Alice", 70000, "IT"),
            new Employee(2, "Bob", 85000, "Finance"),
            new Employee(3, "Charlie", 60000, "HR"),
            new Employee(4, "David", 75000, "IT"),
            new Employee(5, "Eve", 90000, "Finance"),
            new Employee(6, "Frank", 50000, "HR")
        );

        Stream<Employee> employeeStream = employees.stream();

        Map<Boolean, List<Employee>> partionResult = employeeStream
            .collect(Collectors.partitioningBy(e -> e.getSalary() > 70000));

        System.out.println(partionResult); // Here we will get the result in a form of whole Employee Object
        // But we need only name here

        // For the above problem refer below

        Map<Boolean, List<String>> partitionInTwoGroups = employees.stream()
            .collect(Collectors.partitioningBy(em -> em.getSalary() > 70000,
                Collectors.mapping(Employee::getName, Collectors.toList())));

        System.out.println(partitionInTwoGroups);
    }
}
