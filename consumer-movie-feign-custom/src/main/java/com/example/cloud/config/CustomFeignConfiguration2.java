package com.example.cloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.cloud.annotation.ExcludeFromSpringComponentScan;

import feign.Logger;
import feign.auth.BasicAuthRequestInterceptor;

@Configuration
@ExcludeFromSpringComponentScan
public class CustomFeignConfiguration2 {

	@Bean
	public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
		return new BasicAuthRequestInterceptor("chester", "chester");
	}

	@Bean
	Logger.Level feignLoggerLevel() {
		return Logger.Level.FULL;
	}

}
