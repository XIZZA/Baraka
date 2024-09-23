package com.baraka.springboot;

import com.baraka.springboot.model.Employee;
import com.baraka.springboot.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BarakaApplication implements CommandLineRunner {

	@Autowired
	private EmployeeRepository employeeRepository;

		@Override
		public void run(String... args) throws Exception {

		}

		public static void main(String[] args) {
			SpringApplication.run(BarakaApplication.class, args);
		}
	}


