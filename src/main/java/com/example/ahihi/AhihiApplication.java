package com.example.ahihi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import java.util.List;
@SpringBootApplication
public class AhihiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AhihiApplication.class, args);
	}
	@Bean
	CommandLineRunner commandLineRunner(StudentRepository studentRepository){
		return args -> {
			Student maria = new Student(
					"Maria",
					"Jones",
					"maria.jones@amigoscode.edu",
					21
			);

			Student ahmed = new Student(
					"Ahmed",
					"Ali",
					"ahmed.ali@amigoscode.edu",
					18
			);
			System.out.println("Adding maria and ahmed");
			studentRepository.saveAll(List.of(maria, ahmed));
			System.out.print("Number of students: ");
			System.out.println(studentRepository.count());
			studentRepository.findById(3L).ifPresentOrElse(System.out::println,()->System.out.println("Student with ID 2 not found"));
			System.out.println("Select all students");
			List<Student> students = studentRepository.findAll();
			students.forEach(System.out::println);
		};
	}
}
