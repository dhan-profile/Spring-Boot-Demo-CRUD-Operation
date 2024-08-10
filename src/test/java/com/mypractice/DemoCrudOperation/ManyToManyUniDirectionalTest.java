package com.mypractice.DemoCrudOperation;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mypractice.DemoCrudOperation.Entity.Role;
import com.mypractice.DemoCrudOperation.Entity.Users;
import com.mypractice.DemoCrudOperation.Repository.RoleRepository;
import com.mypractice.DemoCrudOperation.Repository.UserRepository;

@SpringBootTest
public class ManyToManyUniDirectionalTest {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;

//	@Test
	public void save() {
	Users user = new Users();
//	user.setUsername("Sakthi");
//	user.setEmail("sakthi@gmail.com");
//	user.setPassword("1234");
	
	Users user2 = new Users();
	user2.setUsername("James");
	user2.setEmail("James@gmail.com");
	user2.setPassword("7894");
	
//    Role admin=new Role();
//    admin.setRoleName("admin");
//    Role user1=new Role();
//    user1.setRoleName("user");
		Role user1=new Role();
		user1.setRoleName("user");
    
//    user.getRole().add(admin);
//    user.getRole().add(user1);
//    userRepository.save(user);
    
    user2.getRole().add(user1);
    userRepository.save(user2);
	}

//	@Test
	  public void saveAll()
	  {
		  Users user1=new Users();
		  user1.setUsername("mouli");
		  user1.setEmail("mouli@gmail.com");
		  user1.setPassword("54321");
	         
	         Users user2=new Users();
	         user2.setUsername("jeyaraj");
	         user2.setEmail("jeyaraj@gmail.com");
	         user2.setPassword("456");
	         
	         Users user3=new Users();
	         user3.setUsername("suresh");
	         user3.setEmail("suresh@gmail.com");
	         user3.setPassword("456789");
	         
	         Role role1=new Role();
	         role1.setRoleName("HR");
		      
		      Role role2=new Role();
		      role2.setRoleName("Data Analyst");
		      
		      user1.getRole().add(role2);
		      user2.getRole().add(role2);
		      user3.getRole().add(role1);
		      
		      userRepository.saveAll(List.of(user1,user2,user3));
	  }
	  
//	  @Test
	  public void updateUser()
	  {
		 Users users= userRepository.findById(1).get(); 
		      users.setPassword("345");
		      users.setEmail("sakthi123@gmail.com");
		      userRepository.save(users);
	  }
	  
//	  @Test
	  public void updateRole() {
		  Role r = roleRepository.findById(3).get();
		  r.setRoleName("Manager");
		  roleRepository.save(r);
	  }
	  
//	  @Test
	  public void getUserRoles()
	  {
		  Users users= userRepository.findById(1).get(); 
		       System.out.println(users.getUsername());
		       System.out.println(users.getPassword());
		       users.getRole()
		       .forEach(n->System.out.println(n.getRoleName()));
	  }
	  
//	  @Test
	  public void deleteUser()
	  {
		  Users users= userRepository.findById(5).get(); 
		  userRepository.delete(users);
	  }
}
