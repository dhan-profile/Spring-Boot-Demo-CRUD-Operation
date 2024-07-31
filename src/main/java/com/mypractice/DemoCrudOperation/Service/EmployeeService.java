package com.mypractice.DemoCrudOperation.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mypractice.DemoCrudOperation.Entity.Employee;
import com.mypractice.DemoCrudOperation.Repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

//	save() - To insert and update in DB
	public Employee saveEmployee(Employee employee) {
		Employee savedEmployee = employeeRepository.save(employee);
		return savedEmployee;
	}

	public Employee getByIdEmployee(int id) {
		Employee employee = employeeRepository.findById(id).get();
		return employee;
	}
	
	public List<Employee> getAllEmployees() {
	    List<Employee> allEmployees = employeeRepository.findAll();
	    return allEmployees;
	}

	public Employee updateEmployee(Employee employee, int id) {
		Employee savedEmployee = employeeRepository.findById(id).get();	// To check if id exists
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
	

	
	
	
	
//	@Autowired
//	private EmployeeRepository employeeRepository;
//	
//	public Employee saveEmployee(Employee employee) {
//		Employee savedEmployee = employeeRepository.save(employee); 
//		return savedEmployee;
//	}
}
