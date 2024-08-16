package com.mypractice.DemoCrudOperation.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

import com.mypractice.DemoCrudOperation.Dto.AppConstants;
import com.mypractice.DemoCrudOperation.Dto.PostResponse;
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
	public ResponseEntity<List<Employee>> saveEmployee(@RequestBody List<Employee> employee) {
	    List<Employee> savedEmployee = employeeService.saveEmployee(employee);
	    return new ResponseEntity<>(savedEmployee,HttpStatus.OK);
//	    return savedEmployee;
	}
	
//	@RequestMapping(value="/getById/{id}")		// {id} = URI template variable
	@GetMapping("/getById/{id}")
	@ResponseBody
	public ResponseEntity<Employee> getById(@PathVariable("id") int id){
		Employee employee=employeeService.getByIdEmployee(id);
		return new ResponseEntity<>(employee,HttpStatus.OK);
	}
	
//	@RequestMapping(value="/getAll", method=RequestMethod.GET)
	@GetMapping("/getAllEmployee")
	@ResponseBody
	public PostResponse getAll(
			@RequestParam(value="pageNumber",defaultValue=AppConstants.PAGE_NUMBER ,required=false) int pageNumber,
		       @RequestParam(value="pageSize",defaultValue=AppConstants.PAGE_SIZE,required=false) int pageSize,
		       @RequestParam(value="sortBy",defaultValue=AppConstants.SORT_BY,required=false) String sortBy,
		       @RequestParam(value="sortDir",defaultValue=AppConstants.SORT_DIR,required=false) String sortDir){
//		List<Employee> employee=employeeService.getAllEmployees();
		PostResponse employees=employeeService.getAllEmployees(pageNumber, pageSize,sortBy,sortDir);
		return employees;
//		return new ResponseEntity<>(employee,HttpStatus.OK);
//		return employee;
	}
	
	@PutMapping("/updateEmployee/{id}")
	@ResponseBody
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee, @PathVariable("id") int id) {
		Employee emp = employeeService.updateEmployee(employee, id);
		return new ResponseEntity<>(emp,HttpStatus.OK);
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
	 public Employee getByEmployeeNameAndLocation(@RequestParam("name")String name, @RequestParam("location") String location){
		return employeeService.getEmployeeByNameAndLocation(name,location);
	 }
	 
	 @GetMapping("/getByIdGreater/{id}")
	 public List<Employee> getByIdGreaterThan(@PathVariable("id") int id){
		return employeeService.getByAgeGreaterThan(id);
	 }
	
//	@RequestParam ==> Bind the value from Query parameter
//	 /getByLocation?location=Chennai
	 @GetMapping("/getByLocation")
	 public List<Employee> getEmployeesByLocation(@RequestParam("location") String location) {
	     return employeeService.getByLocation(location);
	 }
	 
	 
	 @GetMapping("/getByLocationAndName")
	 public Employee findByLocationAndName(@RequestParam(value="location") String location, @RequestParam("name") String name){
		 return employeeService.getBylocationAndName(location,name);
	 }
	 
	 @GetMapping("/getEmployeeNameOrLocation")
	 public List<Employee> getEmployeeByNameOrLocation(@RequestParam("name") String name, @RequestParam("location") String location){
		 return employeeService.getByNameOrLocation(name, location);
	 }
	 
	 @GetMapping("/getNamesStartingA")
	 public List<Employee> getEmployeeStartingWithA(@RequestParam("name") String name){
		 return employeeService.getEmployeeStartingA(name);
	 }
	
//	@RequestMapping(value="/saveEmployee",method=RequestMethod.POST)
//	@ResponseBody
//	public Employee saveEmployee(@RequestBody Employee employee)
//	{
//		Employee savedEmployee=employeeService.saveEmployee(employee);
//		return savedEmployee;
//	}
	
}
