package com.exmaple.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@EnableTurbine
@SpringBootApplication
public class HystrixTurbineWithProjectPathApplication {

	public static void main(String[] args) {
		SpringApplication.run(HystrixTurbineWithProjectPathApplication.class, args);
	}

}
