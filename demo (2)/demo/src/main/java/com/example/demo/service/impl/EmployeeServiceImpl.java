package com.example.demo.service.impl;

import com.example.demo.model.Employee;
import com.example.demo.model.dto.EmployeeDto;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    EmployeeRepository employeeRepository;
    public EmployeeServiceImpl ( EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    public String calculateAge(String dateOfBirth){
        int age = 2025 - Integer.parseInt(dateOfBirth);
        return String.valueOf(age);
    }
    @Override
    public String createEmployee(Employee employee) {
        employeeRepository.save(employee);
        return "Success";
    }

    @Override
    public String updateEmployee(Employee employee) {
        employeeRepository.save(employee);
        return "Success";
    }

    @Override
    public String deleteEmployee(Long employeeId) {
        //more logic to be made
        employeeRepository.deleteById(employeeId);
        return "Success";
    }

    @Override
    public EmployeeDto getEmployee(Long employeeId) {
        Employee employee =  employeeRepository.findById(employeeId).get();
        String age = calculateAge(employee.getDateOfBirth());
        return new EmployeeDto(employee.getId(),employee.getName(),employee.getJobTitle(),employee.getDateOfBirth(),age);
    }

    @Override
    public List<EmployeeDto> getEmployees() {
        // Fetch all employees
        List<Employee> employees = employeeRepository.findAll();

        // Convert each Employee to EmployeeDto and return as a List
        return employees.stream()
                .map(employee -> new EmployeeDto(
                        employee.getId(),
                        employee.getName(),
                        employee.getJobTitle(),
                        employee.getDateOfBirth(),
                        calculateAge(employee.getDateOfBirth())
                ))
                .collect(Collectors.toList());
    }
}
