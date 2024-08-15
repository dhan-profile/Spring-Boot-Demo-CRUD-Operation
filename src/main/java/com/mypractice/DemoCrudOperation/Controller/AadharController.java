package com.mypractice.DemoCrudOperation.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mypractice.DemoCrudOperation.Entity.AadharDetails;
import com.mypractice.DemoCrudOperation.Entity.Student;
import com.mypractice.DemoCrudOperation.Repository.AadharDetailsRepository;
import com.mypractice.DemoCrudOperation.Repository.StudentRepository;
import com.mypractice.DemoCrudOperation.Service.AadharService;

@RestController
@RequestMapping("/api")
public class AadharController {
	@Autowired
	private AadharService aadharService;
	
	@PostMapping("/saveAadhar")
	public AadharDetails saveAadhar(@RequestBody AadharDetails aadharDetails) {
        // Ensure bidirectional consistency before saving
	    return aadharService.saveAadharDetails(aadharDetails);
	}
	
	@GetMapping("/getAllAadharDetails")
	public List<AadharDetails> getAllAadharDetails(){
		List<AadharDetails> aadhar = aadharService.getAadharDetails();
		return aadhar;
	}
}
