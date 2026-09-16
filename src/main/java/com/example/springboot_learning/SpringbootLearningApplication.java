package com.example.springboot_learning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringbootLearningApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringbootLearningApplication.class, args);

		Car car = context.getBean(Car.class);

		car.drive();
	}

}
