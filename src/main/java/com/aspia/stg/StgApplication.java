package com.aspia.stg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class StgApplication {

	public static void main(String[] args) {
		SpringApplication.run(StgApplication.class, args);
	}

}
