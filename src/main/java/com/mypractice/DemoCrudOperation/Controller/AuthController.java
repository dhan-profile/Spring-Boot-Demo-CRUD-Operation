package com.mypractice.DemoCrudOperation.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mypractice.DemoCrudOperation.Dto.LoginDto;
import com.mypractice.DemoCrudOperation.Dto.RegisterDto;
import com.mypractice.DemoCrudOperation.Service.AuthService;

@RestController
@RequestMapping("/api")
public class AuthController
{
	  @Autowired
      private AuthService authService;
	  
	  @PostMapping("/register")
	  public ResponseEntity<String> Register(@RequestBody RegisterDto registerDto)
	  {
		  String message=authService.Register(registerDto);
		  return ResponseEntity.ok(message);
	  }
	  
	  @PostMapping("/login")
	  public ResponseEntity<String> login(@RequestBody LoginDto loginDto)
	  {
		    String message=authService.Login(loginDto);
		    return ResponseEntity.ok(message);
	  }
}