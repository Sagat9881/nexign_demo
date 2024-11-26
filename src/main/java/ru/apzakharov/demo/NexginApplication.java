package ru.apzakharov.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class NexginApplication {

	public static void main(String[] args) {
		SpringApplication.run(NexginApplication.class, args);
	}
		
}
