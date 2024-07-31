package com.mypractice.DemoCrudOperation.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
//	Entity = Table 
//  @Entity means that the class is an Entity(Table)
//	The class name "Employee" is an Entity name (or) NAME of the table
//  The Variables id, name, empid, location are the Fields (or) COLUMNS in a Table 
//@Table(name="employees")
public class Employee {
	
	@Id		// indicates PRIMARY KEY
	@GeneratedValue(strategy=GenerationType.IDENTITY)	// it AUTO INCREMENTs id, usually declared with Primary key
	private int id;
	
//	@Column(name="fullname", length=155)	// changes the COLUMN NAME and LENGTH of characters
	private String name;
	
	private int empid;
	private String location;
	
	
	public Employee() {
//		super();
	}
	
	public Employee(int id, String name, int empid, String location) {
		super();
		this.id = id;
		this.name = name;
		this.empid = empid;
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
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
}
