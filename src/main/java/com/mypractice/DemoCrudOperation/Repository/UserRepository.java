package com.mypractice.DemoCrudOperation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mypractice.DemoCrudOperation.Entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
