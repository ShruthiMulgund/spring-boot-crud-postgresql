package com.example.crud.repository;

import com.example.crud.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface EmployeeRepository  extends JpaRepository<Employee, Long> {

    @Query(name = "firstName")
    Employee findByFirstName(String firstName);

    @Query(name = "lastName")
    Employee findByLastName(String lastName);
}
