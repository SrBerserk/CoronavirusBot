package com.SrBerserk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CoronavirusBottApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoronavirusBottApplication.class, args);
	}

}
