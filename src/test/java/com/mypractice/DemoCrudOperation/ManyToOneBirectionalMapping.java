package com.mypractice.DemoCrudOperation;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mypractice.DemoCrudOperation.Entity.College;
import com.mypractice.DemoCrudOperation.Entity.Staff;
import com.mypractice.DemoCrudOperation.Repository.CollegeRepository;
import com.mypractice.DemoCrudOperation.Repository.StaffRepository;

@SpringBootTest
public class ManyToOneBirectionalMapping {

	@Autowired
	private StaffRepository staffRepository;
	@Autowired
	private CollegeRepository collegeRepository;

//	@Test
  public void save()
  {
  	   College college=new College();
  	           college.setClgName("Anna UniverSity");
  	           
  	    Staff staff1=new Staff();
  	          staff1.setName("arun");
  	          staff1.setLocation("chennai");
  	          staff1.setCollege(college);
  	          
  	          Staff staff2=new Staff();
  	          staff2.setName("sakthi");
  	          staff2.setLocation("madurai");
  	          staff2.setCollege(college);
  	          
  	          college.getStaff().add(staff1);
  	          college.getStaff().add(staff2);
  	          
  	          staffRepository.saveAll(List.of(staff1,staff2));                      
  }

//	@Test
	public void addStaff() {
		College college = collegeRepository.findById(1).get();
		Staff staff1 = new Staff();

		staff1.setName("Kumar");
		staff1.setLocation("Cuddalore");
		staff1.setCollege(college);
		
		college.getStaff().add(staff1);

		collegeRepository.save(college);
	}
	
//	@Test
	   public void deleteClg()
	   {
		   collegeRepository.deleteById(1);
	   }
}
