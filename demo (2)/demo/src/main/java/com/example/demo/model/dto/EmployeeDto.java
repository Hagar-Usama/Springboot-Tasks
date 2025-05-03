package com.example.demo.model.dto;

import com.example.demo.model.Employee;

public class EmployeeDto {

    private Long Id;
    private String name;
    private String jobTitle;
    private String dateOfBirth;
    private String age;

    public EmployeeDto(Long id, String name, String jobTitle, String dateOfBirth, String age) {
        Id = id;
        this.name = name;
        this.jobTitle = jobTitle;
        this.dateOfBirth = dateOfBirth;
        this.age = age;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
