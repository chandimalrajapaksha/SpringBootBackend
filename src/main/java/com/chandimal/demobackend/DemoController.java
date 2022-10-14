package com.chandimal.demobackend;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chandimal.demobackend.Student.Student;
import com.chandimal.demobackend.Student.StudentService;

@RestController
@RequestMapping(path = "/api/v1/student")
public class DemoController {

	private final StudentService studentService;

	@Autowired
	public DemoController(StudentService studentService) {

		this.studentService = studentService;
	}

	// GET Request Mapping
	@GetMapping
	public List<Student> getStudents() {
		return studentService.getStudents();
	}

	// POST Request Mapping
	@PostMapping
	public void registerNewStudent(@RequestBody Student student) {
		studentService.addNewStudent(student);
	}

	// Delete Request Mapping
	@DeleteMapping(path = "{studentId}")
	public void deleteStudent(@PathVariable("studentId") Long id) {
		studentService.deleteStudent(id);

	}

	// PUT Request Mapping
	@PutMapping(path = "{studentId}")
	public void updateStudent(@PathVariable("studentId") Long studentId, @RequestParam(required = false) String name,
			@RequestParam(required = false) String email) {

		studentService.updateStudent(studentId, name, email);

	}

}
