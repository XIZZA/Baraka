package com.baraka.springboot.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @Column(name = "employee_name")
    private String employee_name;

    @Column(name = "email")
    private String email;

    @Column(name = "salary")
    private int salary;

    @Column(name = "age")
    private int age;

}
