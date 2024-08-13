package com.unsa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class UnsaApplication {

	public static void main(String[] args) {
		SpringApplication.run(UnsaApplication.class, args);
	}

}
