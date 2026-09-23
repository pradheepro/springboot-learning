package com.example.springboot_learning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.springboot_learning.other.ExternalEngine;
import com.example.springboot_learning.service.CarService;

@SpringBootApplication
public class SpringbootLearningApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringbootLearningApplication.class, args);

		// Car car = context.getBean(Car.class);
		// ExternalEngine engine =
        // context.getBean(ExternalEngine.class);
		//car.drive();

		CarService carService = context.getBean(CarService.class);

		//carService.start();
	}

}
