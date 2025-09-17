package com.streamPractice;

import com.streamPractice.model.Employee;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/* You are given a list of employees.
👉 Write Java 8 code to:

Group employees by department.

Within each department, return the employees sorted by salary (descending). */
public class SortedSalaryByEmployee {

    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
            new Employee(1, "John", 50000, "IT"),
            new Employee(2, "Alice", 70000, "IT"),
            new Employee(3, "Bob", 60000, "HR"),
            new Employee(4, "Charlie", 80000, "HR"),
            new Employee(5, "David", 75000, "Finance"),
            new Employee(6, "Eve", 72000, "Finance")
        );

        // Group by department and sort within each group
        Map<String, List<Employee>> employeesByDept = employees.stream()
            .collect(Collectors.groupingBy(
                Employee::getDepartment,
                Collectors.collectingAndThen(
                    Collectors.toList(),
                    list -> list.stream()
                        .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                        .collect(Collectors.toList())
                )
            ));

        // Print result
        employeesByDept.forEach((dept, empList) -> {
            System.out.println(dept + " -> " + empList);
        });


    }
}
