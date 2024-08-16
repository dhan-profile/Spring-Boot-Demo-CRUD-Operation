package com.mypractice.DemoCrudOperation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@RestController
@SpringBootApplication
@OpenAPIDefinition(info=@Info(title="Demo CRUD Operation", 
						description="Employee Management system",
						version="Spring Boot version 3.8",
						contact=@Contact(name="admin", email="admin@gmail.com")))

public class DemoCrudOperationApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoCrudOperationApplication.class, args);
		index();
	}
	
	@GetMapping("/")
	private static String index() {
		return "Welcome";
	}
}
