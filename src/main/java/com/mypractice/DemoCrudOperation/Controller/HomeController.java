package com.mypractice.DemoCrudOperation.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@GetMapping("/home")
	public String home() {
		return "Welcome to Home page";
	}
	
	@GetMapping("/payment")
	public String payment() {
		return "Welcome to Payments";
	}

}
