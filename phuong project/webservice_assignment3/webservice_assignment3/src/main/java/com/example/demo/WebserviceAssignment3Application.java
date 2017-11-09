package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication(scanBasePackages={"com.phuong.*"})
@EnableJpaRepositories("com.phuong.repository")
@EntityScan("com.phuong.entities")


public class WebserviceAssignment3Application {

	public static void main(String[] args) {
		SpringApplication.run(WebserviceAssignment3Application.class, args);
	}
}
