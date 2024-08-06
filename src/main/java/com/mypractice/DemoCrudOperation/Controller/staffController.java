package com.mypractice.DemoCrudOperation.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import com.mypractice.DemoCrudOperation.Entity.Staff;
import com.mypractice.DemoCrudOperation.Repository.CollegeRepository;
import com.mypractice.DemoCrudOperation.Repository.StaffRepository;
import com.mypractice.DemoCrudOperation.Service.StaffService;

@RestController
@RequestMapping("/api")
public class staffController {
	 @Autowired
	 private StaffService staffService;
	 @Autowired
	 private CollegeRepository collegeRepository;
	 
	 @PostMapping("/saveStaff")
	 public Staff saveStaff(@RequestBody Staff staff) {
		 Staff savedStaff = staffService.saveStaffDetails(staff);
		 return savedStaff;
	 }
}
