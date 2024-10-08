package com.mypractice.DemoCrudOperation.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mypractice.DemoCrudOperation.Entity.AadharDetails;
import com.mypractice.DemoCrudOperation.Entity.Student;
import com.mypractice.DemoCrudOperation.Repository.AadharDetailsRepository;
import com.mypractice.DemoCrudOperation.Repository.StudentRepository;

@Service
public class AadharService {
	@Autowired
	private AadharDetailsRepository aadharDetailsRepository;
	
	@Autowired
	private StudentRepository studentRepository;
	
	public AadharDetails saveAadharDetails(AadharDetails aadhar) {
//		Student student = aadhar.getStudent();
// 		Save the student first if it doesn't exist
//        if (student.getName() != null && student.getLocation() != null) {
//            studentRepository.save(student);
//        }

		return aadharDetailsRepository.save(aadhar);
	}
	
	public List<AadharDetails> getAadharDetails() {
		return aadharDetailsRepository.findAll();
	}
}
