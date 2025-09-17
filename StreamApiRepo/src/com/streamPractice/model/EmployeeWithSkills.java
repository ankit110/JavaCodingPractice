package com.streamPractice.model;

import java.util.List;

public class EmployeeWithSkills {
    private int id;
    private String name;
    private List<String> skills;

    public EmployeeWithSkills(int id, String name, List<String> skills) {
        this.id = id;
        this.name = name;
        this.skills = skills;
    }

    // Getters
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public List<String> getSkills() {
        return skills;
    }

    @Override
    public String toString() {
        return "EmployeeWithSkills{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", skills=" + skills +
                '}';
    }
}
