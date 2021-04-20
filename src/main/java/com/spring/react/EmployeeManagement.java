package com.spring.react;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan("com.spring.react.io.entity")
public class EmployeeManagement extends SpringBootServletInitializer {
	//Spring Boot will automagically wire this object using application.properties:
	public static void main(String[] args) {

		SpringApplication.run(EmployeeManagement.class, args);

	}


}
