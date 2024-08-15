package com.mypractice.DemoCrudOperation.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mypractice.DemoCrudOperation.Entity.AadharDetails;
import com.mypractice.DemoCrudOperation.Entity.Student;
import com.mypractice.DemoCrudOperation.Repository.AadharDetailsRepository;
import com.mypractice.DemoCrudOperation.Service.StudentService;

@RestController
@RequestMapping("/api")
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private AadharDetailsRepository aadharRepository;
	
	
    @PostMapping("/saveStudent")
    public Student saveStudent(@RequestBody Student student) {
    	Student stud = studentService.saveStudentDetails(student);
        return stud;
    }
	
    @GetMapping("/getAllStudent")
    public List<Student> getAllStudentsDetails() {
    	List<Student> stud = studentService.getAllStudents();
    	return stud;
    }
    
	@DeleteMapping("/deleteStudentById/{id}")
    public Student deleteStudentById(@PathVariable("id") int id) {
		return studentService.deleteStudent(id);
	}
	
	@PutMapping("/updateStudentById/{id}")
	public Student updateStudentById(@RequestBody Student student, @PathVariable("id") int id){
		AadharDetails aadharId = aadharRepository.findById(id).orElseThrow(() -> new RuntimeException("Aadhar Not Found"));
		student.setAadharDetails(aadharId);
		return studentService.updateStudentDetails(student, id);
	}
	
//	@PostMapping("/saveStudent")
//	public Student saveStudent(@RequestBody Student student) {
//	    AadharDetails aadharStudentId = aadharRepository.findById(student.getAadharDetails().getId())
//	            .orElseThrow(() -> new RuntimeException("Aadhar Details Not found"));
//	    student.setAadharDetails(aadharStudentId);
//	    aadharStudentId.setStudent(student);  // Set the reverse reference
//	    return studentService.saveStudentDetails(student);
//	}

}









