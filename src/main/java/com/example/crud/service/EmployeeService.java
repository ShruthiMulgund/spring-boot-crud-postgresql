package com.example.crud.service;

import com.example.crud.dto.EmployeeDto;
import com.example.crud.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(Long id);

    List<EmployeeDto> getAllEmployees();

    EmployeeDto getEmployeeByFirstName(String firstName);

    EmployeeDto getEmployeeByLastName(String lastName);

    EmployeeDto updateEmployee(Long id, EmployeeDto updatedEmployee);

    String deleteEmployee(Long id);
}
