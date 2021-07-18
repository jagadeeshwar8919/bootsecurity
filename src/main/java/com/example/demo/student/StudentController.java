package com.example.demo.student;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {
	
	private static final List<Student> students=Arrays.asList(
			new Student(1,"jagadeeswar reddy"),
			new Student(2,"meenakshi"),
			new Student(3,"narasimha")
			);
	
	@GetMapping(path="/{studentId}")
	public Student getStudent(@PathVariable(value="studentId")Integer studentId) {
		return students.stream()
				        .filter(student ->studentId.equals(student.getStudentId()))
				        .findFirst()
				        .orElseThrow(() -> new IllegalStateException("student "+studentId+" does not exist"));
		
	}
	

}
