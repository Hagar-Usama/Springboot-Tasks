package com.example.demo.controller;


import dto.EmployeeDto;
import com.example.demo.response.ApiResponse;
import com.example.demo.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<ApiResponse<EmployeeDto>> getEmployeeDetails(@PathVariable("employeeId") Long employeeId) {
        System.out.println(employeeId);
        if (employeeId == null) {
            ApiResponse<EmployeeDto> errorResponse = new ApiResponse<>(
                    false,
                    "Employee id must not be null",
                    null
            );
            return ResponseEntity.badRequest().body(errorResponse);
        }

        EmployeeDto employeeDto = employeeService.getEmployee(employeeId);
        ApiResponse<EmployeeDto> response = new ApiResponse<>(true, "Employee retrieved successfully", employeeDto);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<EmployeeDto>>> getEmployeeDetails() {
        List<EmployeeDto> employees = employeeService.getEmployees();
        ApiResponse<List<EmployeeDto>> response = new ApiResponse<>(
                true,
                "Employees retrieved successfully",
                employees
        );
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<EmployeeDto>> createEmployeeDetails(@RequestBody EmployeeDto requestDto) {
        EmployeeDto created = employeeService.createEmployee(requestDto);

        ApiResponse<EmployeeDto> response = new ApiResponse<>(
                true,
                "Employee created successfully",
                created
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


    @PutMapping
    public ResponseEntity<ApiResponse<EmployeeDto>> updateEmployeeDetails( @Valid @RequestBody EmployeeDto requestDto) {
        EmployeeDto updated = employeeService.updateEmployee(requestDto);
        ApiResponse<EmployeeDto> response = new ApiResponse<>(
                true,
                "Employee updated successfully",
                updated
        );
        return ResponseEntity.ok(response);
    }


    @DeleteMapping("/{employeeId}")
    public ResponseEntity<ApiResponse<String>> deleteEmployeeDetails(@PathVariable(required = false) Long employeeId) {
        if (employeeId == null) {
            ApiResponse<String> response = new ApiResponse<>(
                    false,
                    "Employee ID must not be null",
                    null
            );
            return ResponseEntity.badRequest().body(response);
        }

        String result = employeeService.deleteEmployee(employeeId);
        ApiResponse<String> response = new ApiResponse<>(
                true,
                "Employee deleted successfully",
                result
        );
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }


}
