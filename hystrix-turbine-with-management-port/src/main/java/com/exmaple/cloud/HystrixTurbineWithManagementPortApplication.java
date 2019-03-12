package com.exmaple.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@EnableTurbine
@SpringBootApplication
public class HystrixTurbineWithManagementPortApplication {

	public static void main(String[] args) {
		SpringApplication.run(HystrixTurbineWithManagementPortApplication.class, args);
	}

}
