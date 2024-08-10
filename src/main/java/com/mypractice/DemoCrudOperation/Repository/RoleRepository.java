package com.mypractice.DemoCrudOperation.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mypractice.DemoCrudOperation.Entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{
	
	Optional<Role> findByRoleName(String name);
}
