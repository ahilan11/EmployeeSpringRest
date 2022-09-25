package com.springboot.backend.controller;

import com.springboot.backend.model.Employee;
import com.springboot.backend.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.HttpCookie;
import java.util.List;

@RestController
@RequestMapping("api/employees")
public class EmployeeController {

    EmployeeService employeeService;

//Constructor based dependency injection
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    @RequestMapping("saveEmployee")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee ){

        return new ResponseEntity<>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }

    @GetMapping
    @RequestMapping("getAllEmployees")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.FOUND);
    }

    @GetMapping
    @RequestMapping("getEmployeeById/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long id){
        return new ResponseEntity<>(employeeService.getEmployeeById(id),HttpStatus.FOUND);
    }

    @PutMapping
    @RequestMapping("updateEmployee/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id, @RequestBody Employee employee){
        return new ResponseEntity<>(employeeService.updateEmployee(employee, id), HttpStatus.OK);
    }

    @DeleteMapping
    @RequestMapping("deleteEmployee/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id){
        employeeService.deleteEmployee(id);
        return new ResponseEntity<String>("employee deleted", HttpStatus.OK);
    }
}
