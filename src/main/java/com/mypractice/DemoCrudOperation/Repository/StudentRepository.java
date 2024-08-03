package com.mypractice.DemoCrudOperation.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.mypractice.DemoCrudOperation.Entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

}
