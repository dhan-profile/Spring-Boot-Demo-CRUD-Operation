package com.mypractice.DemoCrudOperation.Service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mypractice.DemoCrudOperation.Dto.LoginDto;
import com.mypractice.DemoCrudOperation.Dto.RegisterDto;
import com.mypractice.DemoCrudOperation.Entity.Role;
import com.mypractice.DemoCrudOperation.Entity.Users;
import com.mypractice.DemoCrudOperation.Exception.UserNotFoundException;
import com.mypractice.DemoCrudOperation.Repository.RoleRepository;
import com.mypractice.DemoCrudOperation.Repository.UserRepository;

@Service
public class AuthService {
	private AuthenticationManager authenticationManager;
	private PasswordEncoder passwordEncoder;
	private UserRepository userRepository;
	private RoleRepository roleRepository;
	
	@Autowired
	public AuthService(AuthenticationManager authenticationManager, PasswordEncoder passwordEncoder,
			UserRepository userRepository, RoleRepository roleRepository) {
		super();
		this.authenticationManager = authenticationManager;
		this.passwordEncoder = passwordEncoder;
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
	}
	
	public String Login(LoginDto loginDto) 
	{
    	Authentication authentication=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getEmail(),loginDto.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		return "Login Successful";
	}
	
	public String Register(RegisterDto registerDto) {
		if(userRepository.existsByEmail(registerDto.getEmail())) 
		{
			throw new UserNotFoundException("Email already exist");
		}
		Users user = new Users();
		user.setEmail(registerDto.getEmail());
		user.setUsername(registerDto.getUsername());
		user.setPassword(passwordEncoder.encode(registerDto.getPassword()));
		
		Set<Role> roles = new HashSet<Role>();
//		Role role = roleRepository.findByRoleName("admin").get();
		Role role1 = roleRepository.findByRoleName("USER").get();
//		roles.add(role);
		roles.add(role1);
		user.setRole(roles);
		userRepository.save(user);
		
		return "Registered Successfully";
	}
}

