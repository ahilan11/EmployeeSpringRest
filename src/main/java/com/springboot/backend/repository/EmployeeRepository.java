package com.springboot.backend.repository;

import com.springboot.backend.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

//The @Repository annotation is not necessary because JpaRepository takes care of it
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
