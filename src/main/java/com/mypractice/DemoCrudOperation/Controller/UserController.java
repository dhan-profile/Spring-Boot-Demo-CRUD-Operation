package com.mypractice.DemoCrudOperation.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mypractice.DemoCrudOperation.Entity.User;
import com.mypractice.DemoCrudOperation.Service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/saveUser")
	public User createUser(@RequestBody User user) {
		User savedUser = userService.saveUserDetails(user);
		return savedUser;
	}
	
	@GetMapping("/getAllUser")
	public List<User> getAllUser(){
		List<User> userdtl = userService.getAllUserDetails();
		return userdtl;
	}
}
