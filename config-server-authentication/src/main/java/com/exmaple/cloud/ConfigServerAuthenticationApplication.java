package com.exmaple.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class ConfigServerAuthenticationApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigServerAuthenticationApplication.class, args);
	}

}
