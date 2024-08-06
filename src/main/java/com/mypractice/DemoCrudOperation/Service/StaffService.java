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
	 
	 @Autowired
	 private CollegeRepository collegeRepository;
	 
   public Staff saveStaffDetails(Staff staff)
   {
	   Staff staffSaved = staffRepository.save(staff);
	   return staffSaved;
   }
}
