package com.example.demo.service;

import dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
 public  EmployeeDto createEmployee(EmployeeDto employee);
 public EmployeeDto updateEmployee(EmployeeDto employee);
 public  String deleteEmployee(Long employeeId);
 public EmployeeDto getEmployee(Long employeeId);
 public List<EmployeeDto> getEmployees();
}
