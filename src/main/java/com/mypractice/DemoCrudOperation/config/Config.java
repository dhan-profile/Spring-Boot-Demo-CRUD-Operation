package com.mypractice.DemoCrudOperation.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class Config {
   
	private UserDetailsService userDetailsService;
	
	@Autowired
	public Config(UserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}

//	PasswordEncoder
//	===============
	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
//	AuthenticationManager
//	=====================
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration configure) throws Exception {
		return configure.getAuthenticationManager();
	}
	
//	SecurityFilterChain
//	===================
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .authorizeHttpRequests(req -> req
                .requestMatchers("/home").permitAll()
                .requestMatchers("/api").permitAll()
                .anyRequest().authenticated()
            )
            .formLogin(Customizer.withDefaults())
            .httpBasic(Customizer.withDefaults());

        return http.build();
    }
	
//	@Bean
//	public UserDetailsService userDetailsService() {
//		UserDetails admin = User.builder()
//							.username("Sakthi")
//							.password(passwordEncoder().encode("1234"))
//							.roles("ADMIN")
//							.build();
//		
//		UserDetails user = User.builder()
//							.username("suresh")
//							.password(passwordEncoder().encode("4321"))
//							.roles("USER")
//							.build();
//		
//		return new InMemoryUserDetailsManager(admin, user);
//	}
	
	
	
	
	
	
//  @Bean
//  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//      http.csrf().disable()
//          .authorizeRequests()
//              .requestMatchers("/api").permitAll() // Allow access to /api
//              .anyRequest().authenticated()
//          .and()
//          .httpBasic(); // or formLogin() depending on your security setup
//
//      return http.build();
//  }
	
}
