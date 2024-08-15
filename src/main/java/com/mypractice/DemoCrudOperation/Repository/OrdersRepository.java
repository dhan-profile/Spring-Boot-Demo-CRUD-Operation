package com.mypractice.DemoCrudOperation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mypractice.DemoCrudOperation.Entity.Orders;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Integer>{

}
