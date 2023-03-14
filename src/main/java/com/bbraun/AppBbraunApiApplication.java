package com.bbraun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class AppBbraunApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppBbraunApiApplication.class, args);
	}

}
