package com.mypractice.DemoCrudOperation.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mypractice.DemoCrudOperation.Entity.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer>{
	Optional<Users> findByEmail(String email);
	boolean existsByEmail(String email);
}
