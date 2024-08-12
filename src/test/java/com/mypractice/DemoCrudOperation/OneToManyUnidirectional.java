package com.mypractice.DemoCrudOperation;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

//import com.mypractice.DemoCrudOperation.Entity.College;
//import com.mypractice.DemoCrudOperation.Entity.Staff;
import com.mypractice.DemoCrudOperation.Repository.CollegeRepository;

@SpringBootTest
public class OneToManyUnidirectional {

    @Autowired
    private CollegeRepository collegeRepository;

//    @Test
//    public void saveClgStudent(){
//        		     College college=new College();
//		             college.setClgName("Madras University");
//		             
//		      Staff staff1=new Staff();
//		            staff1.setName("Karthi");
//		            staff1.setLocation("Salem");
//		            
//		            Staff staff2=new Staff();
//		            staff2.setName("Satheesh");
//		            staff2.setLocation("Tiruchi");
//		            
//		            Staff staff3=new Staff();
//		            staff3.setName("Benny");
//		            staff3.setLocation("Chennai");
//		            
//		            
//		            college.getStaff().add(staff1);
//		            college.getStaff().add(staff2);
//		            college.getStaff().add(staff3);
//		            
//		            collegeRepository.save(college);
//    }

//   @Test
//   public void getClgStaff(){
//       College college = collegeRepository.findById(2).get();
//       System.out.println(college.getClgName());
//       
//       List<Staff> staff = college.getStaff();
//       for (Staff st : staff) {
//           System.out.print(st.getName() + " : ");
//           System.out.print(st.getLocation());
//           System.out.println();
//       }
//   }
}
