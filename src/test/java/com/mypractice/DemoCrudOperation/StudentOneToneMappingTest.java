package com.mypractice.DemoCrudOperation;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mypractice.DemoCrudOperation.Entity.AadharDetails;
import com.mypractice.DemoCrudOperation.Entity.Student;
import com.mypractice.DemoCrudOperation.Repository.StudentRepository;

@SpringBootTest
public class StudentOneToneMappingTest {
	
	  @Autowired
      private StudentRepository studentRepository;
	  
//	   @Test
	   public void saveStudent()
	   {
		     Student student =new Student();
		             student.setId(1);
		             student.setName("karthi");
		             student.setLocation("chennai");
		        
		          AadharDetails st=new AadharDetails();
		                        st.setId(3);
		                        st.setAadharNumber(42332447);
		                       
		                  student.setAadharDetails(st);
		                  studentRepository.save(student);
	   }
	  
//	  @Test
	  public void saveStudents()
	  {
		   Student student1=new Student();
		           student1.setName("suresh");
		           student1.setLocation("madurai");
		           
		           Student student2=new Student();
		           student2.setName("Arun");
		           student2.setLocation("tenkasi");
		           
		   
		           AadharDetails st1=new AadharDetails(); 
		                         st1.setAadharNumber(123456l);
		            
		            AadharDetails st2=new AadharDetails(); 
		                          st2.setAadharNumber(456l);
		                  
		                 
		            student1.setAadharDetails(st1);
		            student2.setAadharDetails(st2);
		            
		            studentRepository.saveAll(List.of(student1,student2));                 
	  }
	  
//	  @Test
	  public void updateStudent()
	  {
		  Student student=studentRepository.findById(1).get();
		          student.setLocation("thajavur");
		          student.getAadharDetails().setAadharNumber(11111l);
		          studentRepository.save(student);   
	  }  
	  
	  // @Test
	   public void deleteStudent() {
		   Student student = studentRepository.findById(4).get();
		   studentRepository.delete(student);
	   }
}
