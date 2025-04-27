package com.example.demo.service;

import com.example.demo.model.Employee;
import com.example.demo.model.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
 public  String createEmployee(Employee employee);
 public  String updateEmployee(Employee employee);
 public  String deleteEmployee(Long employeeId);
 public EmployeeDto getEmployee(Long employeeId);
 public List<EmployeeDto> getEmployees();
}
