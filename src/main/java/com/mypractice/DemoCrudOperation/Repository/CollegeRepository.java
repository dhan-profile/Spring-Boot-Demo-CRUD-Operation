package com.mypractice.DemoCrudOperation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mypractice.DemoCrudOperation.Entity.College;

public interface CollegeRepository extends JpaRepository<College, Integer>{

}
