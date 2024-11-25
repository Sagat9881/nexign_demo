package ru.apzakharov.demo;

import org.springframework.boot.SpringApplication;

public class TestNexginApplication {

	public static void main(String[] args) {
		SpringApplication.from(NexginApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
