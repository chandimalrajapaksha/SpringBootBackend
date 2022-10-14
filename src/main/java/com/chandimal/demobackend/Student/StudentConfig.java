package com.chandimal.demobackend.Student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {

	@Bean
	public void show() {
		System.out.println("Hello");

	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
		return args -> {
			Student janith = new Student("Janith", "Janith@gmail.com", LocalDate.of(1995, Month.APRIL, 5));
			Student kasun = new Student("Kasun", "Kasun@gmail.com", LocalDate.of(1995, Month.APRIL, 5));

			studentRepository.saveAll(List.of(janith, kasun));
		};
	}

}
