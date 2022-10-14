package com.chandimal.demobackend.Student;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

	private final StudentRepository studentRepository;

	@Autowired
	public StudentService(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}

	// get all students
	public List<Student> getStudents() {

		return studentRepository.findAll();
	}

	// add new student
	public void addNewStudent(Student student) {

		// get student with insert email
		Optional<Student> studentByEmail = studentRepository.findStudentByEmail(student.getEmail());

		// check student is there with email
		if (studentByEmail.isPresent()) {

			// throw exception
			throw new IllegalStateException("Email is registered");
		}

		// save student
		studentRepository.save(student);

	}

	// delete student
	public void deleteStudent(Long id) {

		// check student is exist with that id
		boolean isExists = studentRepository.existsById(id);

		if (!isExists) {
			throw new IllegalStateException("Student with id " + id + " does not exist");
		}

		// delete student by Id
		studentRepository.deleteById(id);

	}

	// update student
	@Transactional
	public void updateStudent(Long studentId, String name, String email) {

		// find student with insert id
		Student student = studentRepository.findById(studentId)
				.orElseThrow(() -> new IllegalStateException("Student with id " + studentId + " does not exist"));

		if (name != null && name.length() > 0 && !Objects.equals(student.getName(), name)) {

			// update student name
			student.setName(name);
		}

		if (email != null && email.length() > 0 && !Objects.equals(student.getEmail(), email)) {
			Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);

			if (studentOptional.isPresent()) {
				throw new IllegalStateException("Email is registered");
			}
			// update student email
			student.setEmail(email);

		}

	}

}
