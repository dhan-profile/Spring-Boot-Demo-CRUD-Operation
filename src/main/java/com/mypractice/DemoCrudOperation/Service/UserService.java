package com.mypractice.DemoCrudOperation.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.mypractice.DemoCrudOperation.Entity.Users;
import com.mypractice.DemoCrudOperation.Repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
//	public Users saveUserDetails(Users user) {
//		Users userDetails = userRepository.save(user);
//		return userDetails;
//	}
	
	public List<Users> getAllUserDetails(){
		List<Users> userdtl = userRepository.findAll();
		return userdtl;
	}
	
	public Users saveUserDetails(Users user) {
	    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	    user.setPassword(encoder.encode(user.getPassword()));
	    return userRepository.save(user);
	}
}
