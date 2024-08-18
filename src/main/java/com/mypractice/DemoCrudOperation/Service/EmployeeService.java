package com.mypractice.DemoCrudOperation.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mypractice.DemoCrudOperation.Dto.PostResponse;
import com.mypractice.DemoCrudOperation.Entity.Employee;
import com.mypractice.DemoCrudOperation.Exception.EmployeeNotFoundException;
import com.mypractice.DemoCrudOperation.Repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

//	save() - To insert and update in DB | List<> for saving multiple employee 
	public List<Employee> saveEmployee(List<Employee> employees) {
	    List<Employee> savedEmployees = new ArrayList<>();
	    for (Employee employee : employees) {
	        savedEmployees.add(employeeRepository.save(employee));
	    }
	    return savedEmployees;
//		Employee savedEmployee = employeeRepository.save(employee);
//		return savedEmployee;
	}
	
	
	public Employee getByIdEmployee(int id) {
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(()->new EmployeeNotFoundException("EmployeeNotFound"));
		return employee;
	}
	
//	public List<Employee> getAllEmployees() { 
	public PostResponse getAllEmployees(int pageNo, int PageSize, String sortBy, String sortDir) {
//		Sort sort= sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())?Sort.by(sortBy).ascending():Sort.by(sortBy).descending();
   	 
		Pageable pageable= PageRequest.of(pageNo, PageSize);
//  	Pageable pageable= PageRequest.of(pageNo, PageSize,sort); 
   	  Page<Employee> allEmployees= employeeRepository.findAll(pageable);
   	  List<Employee> Employees=allEmployees.getContent();
   	      
   	      PostResponse postResponse=new PostResponse();
   	                   postResponse.setContent(Employees);
   	                   postResponse.setPageNumber(allEmployees.getNumber());
   	                   postResponse.setPageSize(allEmployees.getSize());
   	                   postResponse.setTotalElements(allEmployees.getTotalElements());
   	                   postResponse.setTotalPages(allEmployees.getTotalPages());
   	                   postResponse.setLastPage(allEmployees.isLast());
   	                   return postResponse;
//	    List<Employee> allEmployees = employeeRepository.findAll();
//	    return allEmployees;
	}

	public Employee updateEmployee(Employee employee, int id) {
		Employee savedEmployee = employeeRepository.findById(id).get();	// To get id if exists
		savedEmployee.setName(employee.getName());
		savedEmployee.setLocation(employee.getLocation());
		savedEmployee.setEmpid(employee.getEmpid());
		return employeeRepository.save(savedEmployee);
	}

	public Employee deleteEmployee(int id) {
		Employee savedEmployee = employeeRepository.findById(id).get();
		employeeRepository.deleteById(id);
		return savedEmployee;
	}
	
//	public Employee getEmployeeByName(String name) {
//		return employeeRepository.findByName(name);
//	}
	
    public Employee getEmployeeByName(String name)
    {
   	 return employeeRepository.findByName(name);
    }
    
    public Employee getEmployeeByNameAndLocation(String name,String location)
    {
   	 return employeeRepository.findByNameAndLocation(name,location);
    }
    
    public List<Employee> getByAgeGreaterThan(int id)
    {
   	 return employeeRepository.findByIdGreaterThan(id);
    }

    public List<Employee> getByLocation(String location){
    	return employeeRepository.getByLocation(location);
    }
	
//    public Employee getBylocationAndName(String location, String name) {
//    	return getBylocationAndName(location, name);
//    }
    
    public Employee getBylocationAndName(String location, String name) {
        return employeeRepository.findByLocationAndName(location, name);
    }
    
    public List<Employee> getByNameOrLocation(String name,String location) {
    	return employeeRepository.getEmployeeByNameOrLocation(name,location);
    }
    
    public List<Employee> getEmployeeStartingA(String name){
    	return employeeRepository.getNamesStartingA(name);
    }

	
//	@Autowired
//	private EmployeeRepository employeeRepository;
//	
//	public Employee saveEmployee(Employee employee) {
//		Employee savedEmployee = employeeRepository.save(employee); 
//		return savedEmployee;
//	}
}
