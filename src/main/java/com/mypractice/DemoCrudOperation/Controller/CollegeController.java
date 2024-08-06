package com.mypractice.DemoCrudOperation.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mypractice.DemoCrudOperation.Entity.College;
import com.mypractice.DemoCrudOperation.Repository.CollegeRepository;

@RestController
@RequestMapping("/api")
public class CollegeController {
	
	@Autowired
	private CollegeRepository collegeRepository;
	
	@PostMapping("/saveCollege")
	public College saveCollegeDetail(@RequestBody College clg) {
		College college = collegeRepository.save(clg);
		return college;
	}
}
