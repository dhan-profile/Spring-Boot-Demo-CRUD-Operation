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

//    	Fetch the user(username) by email, (checking if the email exist)
//    	================================================================
//    	throwing an exception if not found,		Eg: admin@gmail.com
        Users user = userRepository.findByEmail(email).orElseThrow(() -> new UserNotFoundException("User with email: " + email + " not found."));

/*     +----------------------------------------------------------------------------------------------+
       |  Map roles to GrantedAuthority objects                                                       |
       |  ======================================                                                      |
       |  * A GrantedAuthority represents a privilege or permission granted to an authenticated user. |
       |  * It defines what actions the user is allowed to perform within the application.            |
       |  * One user can have multiple roles. ==>> (ManyToMany)                                       |
       |  * So, we are getting all roles of a user by using map() function & adding it to Set<>	      |
	   +----------------------------------------------------------------------------------------------+
*/     Set<GrantedAuthority> authorities = user.getRole().stream().map(role -> new SimpleGrantedAuthority(role.getRoleName()))
                							.collect(Collectors.toSet());

/*     * Return a Spring Security User object (of type UserDetails)
       * UserDetails: Returns the authorities granted to the user. Cannot return null
	   * User is a predefined class that has a constructor getting username, password and authorities as parameters
*/      return new User(user.getEmail(), user.getPassword(), authorities);
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
