package com.mentzikof.myPetClinic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class MyPetClinicApplication {
	private static final Logger logger = LoggerFactory.getLogger(MyPetClinicApplication.class);
	  
	public static void main(String[] args) {
		logger.info("Starting");
		logger.error("Starting");
		logger.warn("Starting");
		logger.debug("Starting");
		SpringApplication.run(MyPetClinicApplication.class, args);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
