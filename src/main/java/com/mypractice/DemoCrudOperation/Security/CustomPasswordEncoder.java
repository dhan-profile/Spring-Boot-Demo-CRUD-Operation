package com.mypractice.DemoCrudOperation.Security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class CustomPasswordEncoder {
    public static void main(String[] args)
    {
		   BCryptPasswordEncoder s=new BCryptPasswordEncoder();
		                System.out.println(s.encode("selvin"));
		                 System.out.println(s.encode("admin"));
	  }
}
