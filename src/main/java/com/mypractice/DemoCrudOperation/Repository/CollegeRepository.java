package com.mypractice.DemoCrudOperation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mypractice.DemoCrudOperation.Entity.College;

@Repository
public interface CollegeRepository extends JpaRepository<College, Integer>{

}
