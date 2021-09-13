package com.example.Dispenser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableJpaAuditing
@EnableSwagger2
public class DispenserApplication {

	public static void main(String[] args) {
		SpringApplication.run(DispenserApplication.class, args);
	}
}
