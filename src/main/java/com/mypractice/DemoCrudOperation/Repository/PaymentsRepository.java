package com.mypractice.DemoCrudOperation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mypractice.DemoCrudOperation.Entity.Payments;

@Repository
public interface PaymentsRepository extends JpaRepository<Payments, Integer>{

}
