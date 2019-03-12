package com.example.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
public class ZuulStripPrefixApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulStripPrefixApplication.class, args);
	}

}
