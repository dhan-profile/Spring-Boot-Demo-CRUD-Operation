package com.mypractice.DemoCrudOperation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mypractice.DemoCrudOperation.Entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{

}
