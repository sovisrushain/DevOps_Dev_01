package com.devops.devopsdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class DevopsdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DevopsdemoApplication.class, args);
	}

}
