package com.attract.InstitutionDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories
public class InstitutionDemoApplication {
	

	public static void main(String[] args) {
		SpringApplication.run(InstitutionDemoApplication.class, args);
		
	}
	
	
	
	

}
