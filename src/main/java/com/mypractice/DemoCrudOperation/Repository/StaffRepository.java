package com.mypractice.DemoCrudOperation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mypractice.DemoCrudOperation.Entity.Staff;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Integer>{

}
