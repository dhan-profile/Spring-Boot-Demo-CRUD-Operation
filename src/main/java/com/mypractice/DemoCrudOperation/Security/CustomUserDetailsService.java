package com.mypractice.DemoCrudOperation.Security;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User;
//import org.springframework.boot.autoconfigure.security.SecurityProperties.User;

import com.mypractice.DemoCrudOperation.Entity.Users;
import com.mypractice.DemoCrudOperation.Exception.UserNotFoundException;
import com.mypractice.DemoCrudOperation.Repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        // Fetch the user by email, throwing an exception if not found		Eg: admin@gmail.com
        Users user = userRepository.findByEmail(email).orElseThrow(() -> new UserNotFoundException("User with email: " + email + " not found."));

        // Map roles to GrantedAuthority objects
        Set<GrantedAuthority> authorities = user.getRole().stream().map(role -> new SimpleGrantedAuthority(role.getRoleName()))
                							.collect(Collectors.toSet());

        // Return a Spring Security User object
        return new User(user.getEmail(), user.getPassword(), authorities);
    }
}




//@Service
//public class CustomUserDetailsService implements UserDetailsService {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//
//        Users user = userRepository.findByEmail(email)
//                .orElseThrow(() -> new UserNotFoundException("User Not Found"));
//
//        Set<GrantedAuthority> authorities = user.getRole()
//                .stream()
//                .map(role -> new SimpleGrantedAuthority(role.getRoleName()))
//                .collect(Collectors.toSet());
//
//        // Return a UserDetails object
//        return new User(user.getEmail(), user.getPassword(), authorities);
//    }
//}
