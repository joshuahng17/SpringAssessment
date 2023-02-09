package com.cogent;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmployeeBeans {

	@Bean(name = "emp")
	public Employee getEmployee() {
		Employee employee = new Employee(999, "John Doe", 4999.99);
		return employee;
	}
	
}
