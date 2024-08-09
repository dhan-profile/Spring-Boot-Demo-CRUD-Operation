package com.mypractice.DemoCrudOperation.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mypractice.DemoCrudOperation.Entity.College;
import com.mypractice.DemoCrudOperation.Repository.CollegeRepository;

@Service
public class CollegeService {
	@Autowired
	private CollegeRepository collegeRepository;
	
	public College saveCollegeDetails(College clg) {
		College college = collegeRepository.save(clg);
		return college;
	}
	
	public College getCollegeDetails(int id) {
		College clg = collegeRepository.findById(id).get(); 
		return clg;
	}
}
