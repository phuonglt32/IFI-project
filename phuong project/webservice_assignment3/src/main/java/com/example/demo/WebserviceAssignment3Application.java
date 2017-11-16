package com.example.demo;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.phuong.service.StorageServiceImpl;


@SpringBootApplication(scanBasePackages={"com.phuong.*"})
@EnableJpaRepositories("com.phuong.repository")
@EntityScan("com.phuong.entities")


public class WebserviceAssignment3Application implements CommandLineRunner {

	@Resource
	StorageServiceImpl storageService;
	
	public static void main(String[] args) {
		SpringApplication.run(WebserviceAssignment3Application.class, args);
	}
	
	@Override
	public void run(String... arg) throws Exception {
		//storageService.deleteAll();
		//storageService.init();
		
		//storageService.deleteWithname("anh3.png");
		
		System.out.println("Present Project Directory : "+ System.getProperty("user.dir").replace("\\", "\\\\"));

	}
}
