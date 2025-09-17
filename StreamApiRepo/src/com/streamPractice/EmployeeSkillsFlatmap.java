package com.streamPractice;

import com.streamPractice.model.EmployeeWithSkills;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class EmployeeSkillsFlatmap {

    public static void main(String[] args) {
        List<EmployeeWithSkills> employees = Arrays.asList(
            new EmployeeWithSkills(1, "John", Arrays.asList("Java", "Spring")),
            new EmployeeWithSkills(2, "Alice", Arrays.asList("Python", "AWS")),
            new EmployeeWithSkills(3, "Bob", Arrays.asList("Java", "Docker", "Kubernetes"))
        );

        Set<String> skillsSet = employees.stream().flatMap(
            employeeWithSkills -> employeeWithSkills.getSkills().stream())
            .collect(Collectors.toSet()
        );

        System.out.println(skillsSet);
    }

}
