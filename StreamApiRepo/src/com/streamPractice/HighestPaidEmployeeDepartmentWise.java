package com.streamPractice;

import com.streamPractice.model.Employee;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/* Write Java 8 code to find the highest-paid employee per department. */
public class HighestPaidEmployeeDepartmentWise {

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

//         Highest Salary per department
        Map<Object, Double> highestSalary = employeeStream
            .collect(Collectors.groupingBy(Employee::getDepartment,
                Collectors.collectingAndThen(
                    Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)),
                    e -> e.get().getSalary()
                ))); // Highest Salary per Department

        System.out.println(highestSalary);

//        Highest paid Employee
        Map<String, Optional<Employee>> highestPaidEmployee = employees.stream()
            .collect(Collectors.groupingBy(e -> e.getDepartment(),
                Collectors.maxBy(Comparator.comparingDouble(em -> em.getSalary()))));

        System.out.println(highestPaidEmployee);

//        Highest paid Employee without Optional
        Map<String, Employee> highestPaidEmployeeWithoutOptional = employees.stream()
            .collect(Collectors.groupingBy(
                Employee::getDepartment, Collectors.collectingAndThen(
                    Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)), Optional::get
                )
            ));

        System.out.println(highestPaidEmployeeWithoutOptional);
    }
}
