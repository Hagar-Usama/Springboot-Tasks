package com.example.demo.service.impl;

import com.example.demo.exception.EmployeeNotFoundException;
import com.example.demo.model.Employee;
import dto.EmployeeDto;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.time.Year;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    EmployeeRepository employeeRepository;
    public EmployeeServiceImpl ( EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    public String calculateAge(String dateOfBirth){
        int age =  Year.now().getValue() - Integer.parseInt(dateOfBirth);
        return String.valueOf(age);
    }
    public EmployeeDto createEmployee(EmployeeDto dto) {
        Employee employee = new Employee();
        employee.setName(dto.getName());
        employee.setJobTitle(dto.getJobTitle());
        employee.setDateOfBirth(dto.getDateOfBirth());

        Employee saved = employeeRepository.save(employee);

        String age = calculateAge(saved.getDateOfBirth());
        return new EmployeeDto(
                saved.getId(),
                saved.getName(),
                saved.getJobTitle(),
                saved.getDateOfBirth(),
                age
        );
    }


    @Override
    public EmployeeDto updateEmployee(EmployeeDto employee) {
        Employee existing = employeeRepository.findById(employee.getId())
                .orElseThrow(() -> new EmployeeNotFoundException("Cannot update. Employee not found with ID: " + employee.getId()));

        existing.setName(employee.getName());
        existing.setJobTitle(employee.getJobTitle());
        existing.setDateOfBirth(employee.getDateOfBirth());

        Employee updated = employeeRepository.save(existing);

        String age = calculateAge(updated.getDateOfBirth());
        return new EmployeeDto(
                updated.getId(),
                updated.getName(),
                updated.getJobTitle(),
                updated.getDateOfBirth(),
                age
        );
    }

    @Override
    public String deleteEmployee(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with ID: " + employeeId));

        employeeRepository.delete(employee);
        return "Success";
    }

    @Override
    public EmployeeDto getEmployee(Long employeeId) {

        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with ID: " + employeeId));
        String age = calculateAge(employee.getDateOfBirth());
        return new EmployeeDto(employee.getId(),employee.getName(),employee.getJobTitle(),employee.getDateOfBirth(),age);
    }

    @Override
    public List<EmployeeDto> getEmployees() {
        List<Employee> employees = employeeRepository.findAll();

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
