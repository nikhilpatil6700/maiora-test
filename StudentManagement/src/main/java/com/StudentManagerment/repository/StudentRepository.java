package com.StudentManagerment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.StudentManagerment.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{

	
}
