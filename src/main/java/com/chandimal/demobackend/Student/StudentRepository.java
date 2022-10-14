package com.chandimal.demobackend.Student;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

	// find student using email
	Optional<Student> findStudentByEmail(String email);

}
