package com.example.ahihi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class AhihiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AhihiApplication.class, args);
	}
	@GetMapping("/")
	public String get(){
		return "index";
	}
}
