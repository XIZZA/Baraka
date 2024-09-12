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
			Employee employee = new Employee();
			// ... rest of the code to create and save employees
			employee.setEmployee_name("Jaba Mangi");
			employee.setEmail("jmangi@gmail.com");
			employee.setSalary(65555);
			employee.setAge(88);
			employeeRepository.save(employee);

			Employee employee1 = new Employee();
			employee1.setEmployee_name("Blue Band");
			employee1.setEmail("bband@gmail.com");
			employee1.setSalary(623222);
			employee1.setAge(56);
			employeeRepository.save(employee1);
		}

		public static void main(String[] args) {
			SpringApplication.run(BarakaApplication.class, args);
		}
	}


