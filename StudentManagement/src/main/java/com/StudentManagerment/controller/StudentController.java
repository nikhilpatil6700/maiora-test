package com.StudentManagerment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.StudentManagerment.entity.Student;
import com.StudentManagerment.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;

	@PostMapping("/add")
	public ResponseEntity<?> addNewStudent(@RequestBody Student student){
		studentService.addStudent(student);
		return ResponseEntity.status(HttpStatus.CREATED).body("new student added");
	}
	
	@GetMapping("/updatedage/{id}")
	public ResponseEntity<?> calculateAge(@PathVariable int id){
		Student studentAge = studentService.getStudentAge(id);
		return ResponseEntity.status(HttpStatus.OK).body(studentAge);
	}
	
	@GetMapping("/filter")
	public ResponseEntity<?> getFilteredStudents(){
		List<Student> studentBasedOnAge = studentService.getUpdatedage();
		return ResponseEntity.status(HttpStatus.OK).body(studentBasedOnAge);
	}
}
