package com.mypractice.DemoCrudOperation.Entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Staff {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String location;
	
	@ManyToOne(cascade= {CascadeType.MERGE,CascadeType.PERSIST},fetch=FetchType.EAGER)
	@JoinColumn(name="clgId",referencedColumnName="id")
	private College college;

	public Staff() {
		
	}

	public Staff(int id, String name, String location) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	public College getCollege() {
		return college;
	}

	public void setCollege(College college) {
		this.college = college;
	}
	
}
