package com.baraka.springboot.repository;

import com.baraka.springboot.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    //all crud database methods to interact with the JPA repository
}

