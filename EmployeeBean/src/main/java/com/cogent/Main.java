package com.cogent;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(EmployeeBeans.class);
		Employee e = ctx.getBean("emp", Employee.class);
		System.out.println("Employee ID is: "+e.getEmpId());
		System.out.println("Employee Name is: "+e.getEmpName());
		System.out.println("Employee Salary is: "+e.getEmpSal());
	}
	
}
