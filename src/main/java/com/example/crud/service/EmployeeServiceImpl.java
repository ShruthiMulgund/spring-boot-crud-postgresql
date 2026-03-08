package com.example.crud.service;

import com.example.crud.dto.EmployeeDto;
import com.example.crud.entity.Employee;
import com.example.crud.exception.ResourceNotFoundException;
import com.example.crud.mapper.EmployeeMapper;
import com.example.crud.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee emp = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(emp);
    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {
        return EmployeeMapper.mapToEmployeeDto(employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee with this ID is not found: "+ id)));
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream()
                .map(EmployeeMapper::mapToEmployeeDto).collect(Collectors.toList());
    }

    @Override
    public EmployeeDto getEmployeeByFirstName(String firstName) {
        Employee employee = employeeRepository.findByFirstName(firstName);
        if(employee == null) {
            throw new ResourceNotFoundException("Employee:"+firstName+" not found");
        }
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public EmployeeDto getEmployeeByLastName(String lastName) {
        Employee employee = employeeRepository.findByLastName(lastName);
        if(employee == null) {
            throw new ResourceNotFoundException("Employee:"+lastName+" not found");
        }
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public EmployeeDto updateEmployee(Long id, EmployeeDto updatedEmployee) {
        Employee employee = employeeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Employee with the ID not found: "+id));
        employee.setFirstName(updatedEmployee.getFirstName());
        employee.setLastName(updatedEmployee.getLastName());
        employee.setEmail(updatedEmployee.getEmail());

        return EmployeeMapper.mapToEmployeeDto(employeeRepository.save(employee));
    }

    @Override
    public String deleteEmployee(Long id) {
        EmployeeMapper.mapToEmployeeDto(employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee with this ID is not found: "+ id)));

        employeeRepository.deleteById(id);

        return "Employee deleted successfully!";
    }


}
