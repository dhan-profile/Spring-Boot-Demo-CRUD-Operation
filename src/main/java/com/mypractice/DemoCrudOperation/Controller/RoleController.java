package com.mypractice.DemoCrudOperation.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mypractice.DemoCrudOperation.Entity.Role;
import com.mypractice.DemoCrudOperation.Entity.Users;
import com.mypractice.DemoCrudOperation.Service.RoleService;

@RestController
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	
	@GetMapping("/getUserRoleById/{id}")
	public ResponseEntity<Role> getUserRoleById(@PathVariable("id") int id) {
		Role roleId = roleService.getUserRoles(id);
		return new ResponseEntity<>(roleId, HttpStatus.OK);
	}
}
