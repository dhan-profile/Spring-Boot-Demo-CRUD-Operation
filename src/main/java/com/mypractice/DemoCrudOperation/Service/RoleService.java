package com.mypractice.DemoCrudOperation.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mypractice.DemoCrudOperation.Entity.Role;
import com.mypractice.DemoCrudOperation.Exception.RoleNotFoundException;
import com.mypractice.DemoCrudOperation.Repository.RoleRepository;

@Service
public class RoleService {
	
	@Autowired
	private RoleRepository roleRepository;
	
	public Role getUserRoles(int id) {
		return roleRepository.findById(id).orElseThrow(() -> new RoleNotFoundException("Role ID Not Found"));
	}
}
