package com.baraka.springboot.controller;

import com.baraka.springboot.exception.ResourceNotFoundException;
import com.baraka.springboot.model.Employee;
import com.baraka.springboot.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/baraka/employee")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public List<Employee> getAllEmployee(){
        return employeeRepository.findAll();
    }

    //build create employee REST API
    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeRepository.save(employee);
    }


    //get employee by ID API
    @GetMapping("{ID}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable long ID){
        Employee employee = employeeRepository.findById(ID)
                .orElseThrow(() -> {
                    return new ResourceNotFoundException("Employee not found with ID: " + ID);
                });
        return ResponseEntity.ok(employee);
    }

    //building UPDATE REST API
    @PutMapping("{ID}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long ID, @RequestBody Employee employeeDetails) {
        Employee updateEmployee = employeeRepository.findById(ID)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with ID:" + ID));


        updateEmployee.setEmployee_name(employeeDetails.getEmployee_name());
        updateEmployee.setEmail(employeeDetails.getEmail());
        updateEmployee.setSalary(employeeDetails.getSalary());
        updateEmployee.setAge(employeeDetails.getAge());

        employeeRepository.save(updateEmployee);

        return ResponseEntity.ok(updateEmployee);
    }

    //build delete REST API
    @DeleteMapping("{ID}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable long ID){

        Employee employee;
        employee = employeeRepository.findById(ID)
                .orElseThrow(() ->new ResourceNotFoundException("Employee does not exist" + ID));

        employeeRepository.delete(employee);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
