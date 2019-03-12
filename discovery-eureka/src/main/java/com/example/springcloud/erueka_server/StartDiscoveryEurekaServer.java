package com.example.springcloud.erueka_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class StartDiscoveryEurekaServer {

	public static void main(String[] args) {
		SpringApplication.run(StartDiscoveryEurekaServer.class, args);
	}

}
