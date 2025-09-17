package com.streamPractice;

import com.streamPractice.model.Employee;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmployeeSalary {

    public static void main(String[] args) {
        List<Employee> employeeList = Arrays.asList(
        new Employee(1, "John", 50000, "IT"),
            new Employee(2, "Alice", 70000, "IT"),
            new Employee(3, "Bob", 60000, "HR"),
            new Employee(4, "Charlie", 80000, "HR"),
            new Employee(5, "David", 75000, "Finance"));

        Stream<Employee> streamList = employeeList.stream();

        Map<String, Employee> employeeMap = streamList.collect(Collectors.groupingBy(
            employee -> employee.getDepartment(), Collectors.collectingAndThen(
                Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)),
                Optional::get
            )
        ));

        System.out.println(employeeMap);
    }

}
