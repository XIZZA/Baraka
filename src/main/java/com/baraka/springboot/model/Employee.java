package com.baraka.springboot.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.regex.Pattern;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;

    @Column(name = "employee_name", length = 30, nullable = false)
    private String employee_name;

    @Column(name = "email", length = 20, nullable = false)
    private String email;

    @Column(name = "salary", nullable = false)
    private int salary;

    @Column(name = "age", nullable = false)
    private int age;

    @PrePersist
    protected void onCreate() {
        if (salary > 999999999) {
            throw new IllegalArgumentException("Salary cannot be more than 9 integers");
        }
        if (age < 18 || age > 70) {
            throw new IllegalArgumentException("Age must be between 18 and 70");
        }

        // Validate email using a regular expression
        String emailRegex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}$";
        if (!Pattern.matches(emailRegex, email)) {
            throw new IllegalArgumentException("Invalid email format");
        }
    }
}