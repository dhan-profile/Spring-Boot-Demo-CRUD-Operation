package com.mypractice.DemoCrudOperation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mypractice.DemoCrudOperation.Entity.AadharDetails;

@Repository
public interface AadharDetailsRepository extends JpaRepository<AadharDetails, Integer>{

}
