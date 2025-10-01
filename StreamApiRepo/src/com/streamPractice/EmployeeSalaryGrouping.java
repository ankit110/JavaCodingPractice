package com.streamPractice;

import com.streamPractice.model.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmployeeSalaryGrouping {

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

        Map<String, List<Employee>> employeeSalary = employeeStream.collect(
            Collectors.groupingBy((employee) -> {
                if(employee.getSalary() < 60000) return "Low";
                else if(employee.getSalary() <= 80000) return "Medium";
                else return "High";
            })
        );

        System.out.println(employeeSalary);

    }
}
