package com.mypractice.DemoCrudOperation.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mypractice.DemoCrudOperation.Entity.AadharDetails;
import com.mypractice.DemoCrudOperation.Entity.Student;
import com.mypractice.DemoCrudOperation.Repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private StudentRepository studentRepository;
	
	public Student saveStudentDetails(Student student) {
		
//	  +======================================================================================+
//    | 🔺 This 👇 will save both Student-🤵 and AadharDetails-🎫 due to 👉 CascadeType.ALL 🔺 |
//	  +======================================================================================+
		return studentRepository.save(student);
	}
	
	public List<Student> getAllStudents() {
		List<Student> allStudents = studentRepository.findAll();
		return allStudents;
	}

	public Student deleteStudent(int id) {
		Student student = studentRepository.findById(id).get();
		studentRepository.deleteById(id);
		return student;
	}
	
	public Student updateStudentDetails(Student student, int id) {
		Student studentId = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
		studentId.setName(student.getName());
		studentId.setLocation(student.getLocation());
		return studentId;
	}
}
