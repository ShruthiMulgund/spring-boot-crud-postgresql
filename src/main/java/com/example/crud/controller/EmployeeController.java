package com.example.crud.controller;

import com.example.crud.dto.EmployeeDto;
import com.example.crud.service.EmployeeService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) {
        return new ResponseEntity<>(employeeService.createEmployee(employeeDto), HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @GetMapping("/firstName")
    public ResponseEntity<EmployeeDto> getEmployeeByFirstName(@RequestParam String firstName) {
        return ResponseEntity.ok(employeeService.getEmployeeByFirstName(firstName));
    }

    @GetMapping("/lastName")
    public ResponseEntity<EmployeeDto> getEmployeeByLastName(@RequestParam String lastName) {
        return ResponseEntity.ok(employeeService.getEmployeeByLastName(lastName));
    }

    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable Long id, @RequestBody EmployeeDto employeeDto) {
        return ResponseEntity.ok(employeeService.updateEmployee(id, employeeDto));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteEmployee(@RequestParam Long id) {
        return ResponseEntity.ok(employeeService.deleteEmployee(id));
    }


}
