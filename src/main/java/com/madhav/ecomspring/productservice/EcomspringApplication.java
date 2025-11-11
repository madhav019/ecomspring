package com.madhav.ecomspring.productservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class EcomspringApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcomspringApplication.class, args);
	}

}
