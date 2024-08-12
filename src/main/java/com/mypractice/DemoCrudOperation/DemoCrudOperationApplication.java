package com.mypractice.DemoCrudOperation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
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
