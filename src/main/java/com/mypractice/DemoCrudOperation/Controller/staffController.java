package com.mypractice.DemoCrudOperation.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mypractice.DemoCrudOperation.Entity.College;
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
	        College college = collegeRepository.findById(staff.getCollege().getId()).orElseThrow(() -> new RuntimeException("College not found"));
	        staff.setCollege(college);
	        return staffService.saveStaffDetails(staff);
	    }
	    
	    @GetMapping("/getStaffById/{id}")
	    public Staff getStaffById(@PathVariable("id") int id) {
	    	return staffService.getStaffDetails(id);
	    }
	    
	    @DeleteMapping("/deleteById/{id}")
	    public Staff deleteById(@PathVariable("id") int id) {
	    	return staffService.deleteStaff(id);
	    }
	    
	    @PutMapping("/updateStaff/{id}")
	    public Staff updateStaff(@RequestBody Staff staff, @PathVariable("id") int id) {
	        College college = collegeRepository.findById(staff.getCollege().getId()).orElseThrow(() -> new RuntimeException("College not found"));
	        staff.setCollege(college);
	        return staffService.updateStaffDetails(staff, id);
	    }


	    
//	    @PutMapping("/updateStaff/{id}")
//	    public Staff updateStaff(Staff staff, @PathVariable("id") int id) {
//	    	College college = collegeRepository.findById(staff.getCollege().getId()).orElseThrow(() -> new RuntimeException("College not found"));
//	    	staff.setCollege(college);
//	    	return staffService.updateStaffDetails(staff, id);
//	    }
}
