package com.StudentManagerment.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.StudentManagerment.entity.Student;
import com.StudentManagerment.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public void addStudent(Student student) {
		int age = calculateAge(student);
		student.setAge(age);
		studentRepository.save(student);
	}
	
	@Override
	public List<Student> getUpdatedage() {
		List<Student> studentList = studentRepository.findAll();
		return studentList.stream().filter(age->age.getAge()>18 && age.getAge()<25)													.collect(Collectors.toList());
	}

	@Override
	public Student getStudentAge(int id) {
		Student student = studentRepository.findById(id).get();
		int age = calculateAge(student);
		student.setAge(age);
		student.setAge(age);
		return student;
	}
	
	private int calculateAge(Student student) {
		LocalDate dob = student.getDob();
		int age = Period.between(dob, LocalDate.now()).getYears();
		return age;
	}

}
