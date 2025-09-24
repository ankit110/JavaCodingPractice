package com.streamPractice;

import com.streamPractice.model.Employee;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AverageSalaryEachDepartment {

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

        Map<String, Double> averageSalary = employees.stream()
            .collect(Collectors.groupingBy(Employee::getDepartment,
                Collectors.averagingDouble(Employee::getSalary)))
            .entrySet()
            .stream()
            .filter(e -> e.getValue() > 70000)
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        System.out.println(averageSalary);
        // output :- {Finance=88333.33333333333, IT=76666.66666666667}

        // But we need formatted output

        DecimalFormat df = new DecimalFormat("#.##");

        Map<String, String> averageSalaryFormatted = employees.stream()
            .collect(Collectors.groupingBy(Employee::getDepartment,
                Collectors.collectingAndThen(
                    Collectors.averagingDouble(Employee::getSalary), avg -> df.format(avg)
                )))
            .entrySet()
            .stream()
            .filter(emp -> Double.parseDouble(emp.getValue())  > 70000)
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        System.out.println("-----------------------------");
        System.out.println("Formatted:- 👇👇");
        System.out.println(averageSalaryFormatted);
    }
}
