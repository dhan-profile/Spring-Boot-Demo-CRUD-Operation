package com.mypractice.DemoCrudOperation.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class AadharDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private long aadharNumber;
	
//	=================================================
//	🔺 mappedBy is used to define Bi-direcional mapping
//	=================================================
//	@OneToOne(cascade=CascadeType.ALL,mappedBy="aadharDetails",fetch=FetchType.EAGER)
	
//	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
//	@JoinColumn(name="studentId", referencedColumnName="id")
//	 @JsonManagedReference
//	private Student student;
	
	public AadharDetails() {
	}
	
	public AadharDetails(int id, long aadharNumber) {
		this.id = id;
		this.aadharNumber = aadharNumber;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getAadharNumber() {
		return aadharNumber;
	}
	public void setAadharNumber(long aadharNumber) {
		this.aadharNumber = aadharNumber;
	}

//	public Student getStudent() {
//		return student;
//	}
//
//	public void setStudent(Student student) {
//		this.student = student;
//	}
}
