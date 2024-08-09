package com.mypractice.DemoCrudOperation.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mypractice.DemoCrudOperation.Entity.Staff;
import com.mypractice.DemoCrudOperation.Repository.CollegeRepository;
import com.mypractice.DemoCrudOperation.Repository.StaffRepository;

@Service
public class StaffService {
	 @Autowired
	 private StaffRepository staffRepository;
	 	 
   public Staff saveStaffDetails(Staff staff)
   {
	   Staff staffSaved = staffRepository.save(staff);
	   return staffSaved;
   }
   
   public Staff getStaffDetails(int id) {
	   return staffRepository.findById(id).get();
   }
   
   public Staff deleteStaff(int id) {
	   Staff deletedStaff = staffRepository.findById(id).get();
	   staffRepository.deleteById(id);
	   return deletedStaff;
   }

   public Staff updateStaffDetails(Staff staff, int id) {
	    Staff staffId = staffRepository.findById(id).orElseThrow(() -> new RuntimeException("Staff not found"));
	    staffId.setName(staff.getName());
	    staffId.setLocation(staff.getLocation());
	    staffId.setCollege(staff.getCollege());
	    return staffRepository.save(staffId);
	}

   
   
//   public Staff updateStaffDetails(Staff staff, int id) {
//	   Staff staffId = staffRepository.findById(id).get();
//	   staffId.setName(staff.getName());
//	   staffId.setLocation(staff.getLocation());
//	   staffId.setCollege(staff.getCollege());
//	   return staffRepository.save(staffId);
//   }
}
