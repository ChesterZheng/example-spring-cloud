package com.example.cloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.cloud.annotation.ExcludeFromSpringComponentScan;

import feign.Contract;

@Configuration
@ExcludeFromSpringComponentScan
public class CustomFeignConfiguration1 {

	@Bean
	public Contract feignContracet() {
		return new feign.Contract.Default();
	}

}
