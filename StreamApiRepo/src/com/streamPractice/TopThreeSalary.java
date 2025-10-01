package com.streamPractice;

import com.streamPractice.model.Employee;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TopThreeSalary {

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

        List<Employee> topThreeSalary = employees.stream()
            .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
            .limit(3)
            .collect(Collectors.toList());

        System.out.println(topThreeSalary);

        List<String> top3Slaried = employees.stream()
            .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
            .limit(3)
            .map(Employee::getName)
            .collect(Collectors.toList());

        System.out.println(top3Slaried);

        List<Double> topSalary = employees.stream()
            .map(Employee::getSalary)
            .distinct()
            .sorted(Comparator.reverseOrder())
            .limit(3)
            .collect(Collectors.toList());

        List<String> salaryRes = employees.stream()
            .filter(employee -> topSalary.contains(employee.getSalary()))
            .map(Employee::getName)
            .distinct()
            .toList();

        System.out.println(salaryRes);
    }
}
