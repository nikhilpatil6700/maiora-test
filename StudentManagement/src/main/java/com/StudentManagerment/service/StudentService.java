package com.StudentManagerment.service;

import java.util.List;

import com.StudentManagerment.entity.Student;

public interface StudentService {

	void addStudent(Student student);
	
	Student getStudentAge(int id);
	
	List<Student> getUpdatedage();
}
