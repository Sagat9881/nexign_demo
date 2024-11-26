package ru.apzakharov.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import ru.apzakharov.demo.application.model.task.Task;

@SpringBootApplication
@EnableScheduling
public class NexginApplication {

	public static void main(String[] args) {
		SpringApplication.run(NexginApplication.class, args);
	}
		
}
