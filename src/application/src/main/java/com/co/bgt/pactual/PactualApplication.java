package com.co.bgt.pactual;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.co.bgt.*"})
public class PactualApplication {

	public static void main(String[] args) {
		SpringApplication.run(PactualApplication.class, args);
	}

}
