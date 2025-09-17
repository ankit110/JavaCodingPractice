package com.streamPractice;

import com.streamPractice.model.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/* Write Java 8 code to find the
    average salary of employees per department. */
public class AverageSalaryPerDepartment {

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

        Map<String, Double> averageSalaryDepartment = employeeStream
            .collect(Collectors.groupingBy(employee ->
                employee.getDepartment(), Collectors.averagingDouble(e ->
                e.getSalary())));

        System.out.println(averageSalaryDepartment);
    }
}
