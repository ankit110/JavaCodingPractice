package com.streamPractice;

import com.streamPractice.model.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OptionalEmployeeSalary {

    public static void main(String[] args) {
        List<Employee> employeeList = Arrays.asList(
            new Employee(2, "Alice", 70000, "IT"),
            new Employee(3, "Bob", 60000, "HR"),
            new Employee(4, "Charlie", 80000, "HR"),
            new Employee(5, "David", 75000, "Finance"),
            new Employee(6, "Alex", 77000, "Finance")
        );

        Stream<Employee> employeeStream = employeeList.stream();

        Optional<Employee> employeeOptional = employeeStream
            .filter(employee -> employee.getSalary() > 75000)
            .findFirst();

        System.out.println(employeeOptional);

        // Another way using without using (findFirst() or findAny()),
        // we can go with filter + collect method and return first index of resultant list.

        Stream<Employee> employeeCollectStream = employeeList.stream();

        List<Employee> filteredList = employeeCollectStream
            .filter(employee -> employee.getSalary() > 75000)
            .collect(Collectors.toList());

        Optional<Employee> resultantEmployee =
            filteredList.isEmpty() ? Optional.empty()
                : Optional.of(filteredList.get(0));

        System.out.println(resultantEmployee);
    }
}
