package com.mypractice.DemoCrudOperation.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mypractice.DemoCrudOperation.Entity.User;
import com.mypractice.DemoCrudOperation.Repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User saveUserDetails(User user) {
		User userDetails = userRepository.save(user);
		return userDetails;
	}
	
	public List<User> getAllUserDetails(){
		List<User> userdtl = userRepository.findAll();
		return userdtl;
	}
}
