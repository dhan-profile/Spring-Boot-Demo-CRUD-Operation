package com.mypractice.DemoCrudOperation;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mypractice.DemoCrudOperation.Entity.AadharDetails;
import com.mypractice.DemoCrudOperation.Entity.Student;
import com.mypractice.DemoCrudOperation.Repository.AadharDetailsRepository;
import com.mypractice.DemoCrudOperation.Repository.StudentRepository;

@SpringBootTest
public class OneToOneBiDirectionalMapping {
	
	@Autowired
	private AadharDetailsRepository aadharDetailsRepository;
	
//	@Test
	public void saveAadharDetails(){
		AadharDetails aadharDetails = new AadharDetails();
		aadharDetails.setAadharNumber(45635461);
		
		Student student = new Student();
		student.setName("Deepak");
		student.setLocation("Tiruchi");
		
		student.setAadharDetails(aadharDetails);
		aadharDetails.setStudent(student);
		
		aadharDetailsRepository.save(aadharDetails);
	}
	
//	 @Test
	 public void findAadhardetails()
	 {
		 AadharDetails aadharDetails= aadharDetailsRepository.findById(1).get();
		      System.out.println(aadharDetails.getAadharNumber());
	 }
	 
//	 @Test
	 public void updateAaadhar()
	 {
	  AadharDetails aadharDetails= aadharDetailsRepository.findById(1).get();
	                aadharDetails.setAadharNumber(5678l);
	                aadharDetails.getStudent().setLocation("madurai");
	                aadharDetailsRepository.save(aadharDetails);
	 }
}
