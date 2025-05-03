package dto;

import jakarta.validation.constraints.NotNull;

public class EmployeeDto {
    @NotNull(message = "Employee ID must not be null for update")
    private Long id;
    private String name;
    private String jobTitle;
    private String dateOfBirth;
    private String age;

    public EmployeeDto(Long id, String name, String jobTitle, String dateOfBirth, String age) {
        this.id = id;
        this.name = name;
        this.jobTitle = jobTitle;
        this.dateOfBirth = dateOfBirth;
        this.age = age;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
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
