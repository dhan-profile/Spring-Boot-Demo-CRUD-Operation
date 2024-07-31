package com.mypractice.DemoCrudOperation.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mypractice.DemoCrudOperation.Entity.Employee;
import com.mypractice.DemoCrudOperation.Service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	@Autowired
    private EmployeeService employeeService;

//	@RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)

	@PostMapping("/saveEmployee")
	@ResponseBody
	public Employee saveEmployee(@RequestBody Employee employee) {
	    Employee savedEmployee = employeeService.saveEmployee(employee);
	    return savedEmployee;
	}
	
	@RequestMapping(value="/getById/{id}")		// {id} = URI template variable 
	@ResponseBody
	public Employee getById(@PathVariable("id") int id)
	{
		Employee employee=employeeService.getByIdEmployee(id);
		return employee;
	}
	
//	@RequestMapping(value="/getAll", method=RequestMethod.GET)
	@GetMapping("/getAll")
	@ResponseBody
	public List<Employee> getAll()
	{
		List<Employee> employee=employeeService.getAllEmployees();
		return employee;
	}
	
	@PutMapping("/updateEmployee/{id}")
	@ResponseBody
	public Employee updateEmployee(@RequestBody Employee employee, @PathVariable("id") int id) {
		return employeeService.updateEmployee(employee, id);
	}
	
	@DeleteMapping("/deleteEmployee/{id}")
	@ResponseBody
	public Employee deleteEmployee(@PathVariable("id") int id) {
	    return employeeService.deleteEmployee(id);
	}

//	@GetMapping("/getName")
//	public Employee getEmployeeByName(@RequestParam("name") String name) {
//		return employeeService.getEmployeeByName(name);
//	}
	
	 @GetMapping("/getName/")
	 public Employee getEmployeeByName(@RequestParam("name") String name)
	 {
		return employeeService.getEmployeeByName(name);
	 }
	 
	 @GetMapping("/getNameAndLocation/")
	 public Employee getByEmployeeNameAndLocation(
			                                   @RequestParam("name")String name,
			                                   @RequestParam("location") String location)
	 {
		return employeeService.getEmployeeByNameAndLocation(name,location);
	 }
	 
	 @GetMapping("/getByIdGreater/{id}")
	 public List<Employee> getByIdGreaterThan(@PathVariable("id") int id)
	 {
		return employeeService.getByAgeGreaterThan(id);
	 }
	
	
	
	
	
//	@RequestParam ==> Bind the value from Query parameter
	
	
	
//	@RequestMapping(value="/saveEmployee",method=RequestMethod.POST)
//	@ResponseBody
//	public Employee saveEmployee(@RequestBody Employee employee)
//	{
//		Employee savedEmployee=employeeService.saveEmployee(employee);
//		return savedEmployee;
//	}
	
}
