package com.streamPractice;

import com.streamPractice.model.Employee;

import java.util.*;
import java.util.stream.Collectors;

public class TopThreeWithTiesMap {
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

        // Step 1: Extract top 3 distinct salaries
        List<Double> topSalaries = employees.stream()
            .map(Employee::getSalary)
            .distinct()
            .sorted(Comparator.reverseOrder())
            .limit(3)
            .collect(Collectors.toList());

        // Step 2: Group employees by salary (only top 3 salaries)
        Map<Double, List<Employee>> top3SalaryGroups = employees.stream()
            .filter(emp -> topSalaries.contains(emp.getSalary()))
            .collect(Collectors.groupingBy(Employee::getSalary));

        System.out.println(top3SalaryGroups);

        Map<Double, List<String>> top3SalaryGroupsNames = employees.stream()
            .filter(emp -> topSalaries.contains(emp.getSalary()))
            .collect(Collectors.groupingBy(
                Employee::getSalary,                     // key = salary
                Collectors.mapping(Employee::getName,   // value = names only
                    Collectors.toList())
            ));

        System.out.println(top3SalaryGroupsNames);
    }
}
