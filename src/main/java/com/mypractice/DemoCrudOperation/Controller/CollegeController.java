package com.mypractice.DemoCrudOperation.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mypractice.DemoCrudOperation.Entity.College;
import com.mypractice.DemoCrudOperation.Repository.CollegeRepository;
import com.mypractice.DemoCrudOperation.Service.CollegeService;

@RestController
@RequestMapping("/api")
public class CollegeController {
	
	@Autowired
	private CollegeService collegeService;
	
	@PostMapping("/saveCollege")
	public College saveCollegeDetail(@RequestBody College clg) {
		College college = collegeService.saveCollegeDetails(clg);
		return college;
	}
	
	@GetMapping("/getCollegeById/{id}")
	public College getCollegeDetails(@PathVariable("id") int id) {
		College college = collegeService.getCollegeDetails(id);
		return college;
	}
}
