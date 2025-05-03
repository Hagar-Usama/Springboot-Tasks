package com.example.demo.controller;


import com.example.demo.model.Employee;
import com.example.demo.model.dto.EmployeeDto;
import com.example.demo.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    EmployeeService employeeService;

    public EmployeeController (EmployeeService employeeService)
    {
        this.employeeService = employeeService;
    }

    @GetMapping("{employeeId}")
    public EmployeeDto getEmployeeDetails(@PathVariable("employeeId") Long employeeId)
    {
        return employeeService.getEmployee(employeeId);
    }

    @GetMapping()
    public List<EmployeeDto> getEmployeeDetails()
    {
        return employeeService.getEmployees();
    }
    @PostMapping
    public String createEmployeeDetails(@RequestBody Employee employee)
    {
       employeeService.createEmployee(employee);
       return "Employee Created Successfully";
    }

    @PutMapping
    public String updateEmployeeDetails(@RequestBody Employee employee)
    {
        employeeService.updateEmployee(employee);
        return "Employee Updated Successfully";
    }

    @DeleteMapping("/{employeeId}")
    public String deleteEmployeeDetails(@PathVariable Long employeeId)
    {
        employeeService.deleteEmployee(employeeId);
        return "Employee Deleted Successfully";
    }

}
