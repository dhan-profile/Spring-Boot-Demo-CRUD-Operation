package com.mypractice.DemoCrudOperation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mypractice.DemoCrudOperation.Entity.Staff;

public interface StaffRepository extends JpaRepository<Staff, Integer>{

}
