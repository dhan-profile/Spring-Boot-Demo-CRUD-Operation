package com.mypractice.DemoCrudOperation.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mypractice.DemoCrudOperation.Entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
//	public Employee findByName(String name);
	
    public Employee findByName(String name);
//    findBy = Predicate,  Name = Subject
    
    public Employee findByNameAndLocation(String name,String location);
//    findBy = Predicate, Name = Subject, And = Predicate, Location = Subject
    
    public List<Employee> findByIdGreaterThan(int id);
//    findBy = Predicate, Id= Subject, GreaterThan = Predicate
    
    
    
//	JPQL - Java Persistance Query Language
//	jpql  entity based query
//	get the data from database using jpql index param
//	jpql convert into native Query 
    
    @Query("SELECT u FROM Employee u WHERE u.location = :location")
    public List<Employee> getByLocation(@Param("location") String location);
    
    //@Query(value="select u from Employee u where location=?1 and name=?2")
    //jpql - fetch the data from database using named param
    @Query(value="select u from Employee u where location=:location and name=:name")
    public Employee findByLocationAndName(@Param("location")String location,@Param("name")String name);
    //The value keyword is to specify multiple attributes in the @Query annotation.
    
    //Native Query - native query used to fetch data from database index param
    @Query(value="select * from Employee where id=?1",nativeQuery=true)
    public Employee getEmployeeIdAndLocation(int id);
    
    //native Query named param
    @Query(value="select * from Employee where name=:name or location=:location",nativeQuery=true)
    public List<Employee> getEmployeeByNameOrLocation(@Param("name")String name,@Param("location")String location);
    
    @Query(value="select * from Employee where name like 'A%'", nativeQuery=true)
    public List<Employee> getNamesStartingA(@Param("name") String name);
}










//================================================
// Employee 		=> Table Name (OR) Entity Name
// Integer 			=> DataType of Primary Key
// JPA Repository 	=> A specification for ORM (Access data through Objects)
//					It extends CrudRepository which contains methods for DB Queries
//======================================================