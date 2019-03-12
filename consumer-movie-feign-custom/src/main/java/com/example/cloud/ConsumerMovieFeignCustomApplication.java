package com.example.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

import com.example.cloud.annotation.ExcludeFromSpringComponentScan;

@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
@ComponentScan(excludeFilters = {
		@ComponentScan.Filter(type = FilterType.ANNOTATION, value = ExcludeFromSpringComponentScan.class) })
public class ConsumerMovieFeignCustomApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerMovieFeignCustomApplication.class, args);
	}

}
