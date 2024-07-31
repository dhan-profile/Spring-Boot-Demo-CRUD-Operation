package com.mypractice.DemoCrudOperation.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mypractice.DemoCrudOperation.Entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
//	public Employee findByName(String name);
	
    public Employee findByName(String name);
    
    public Employee findByNameAndLocation(String name,String location);
    
    public List<Employee> findByIdGreaterThan(int id);
}




















//================================================
// Employee 		=> Table Name (OR) Entity Name
// Integer 			=> DataType of Primary Key
// JPA Repository 	=> A specification for ORM (Access data through Objects)
//					   It extends CrudRepository which contains methods for DB Queries