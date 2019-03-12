package com.example.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.client.RestTemplate;

import com.example.cloud.annotation.ExcludeFromSpringComponentScan;
import com.example.cloud.config.CustomRibbonConfiguration;

@EnableEurekaClient
@ComponentScan(excludeFilters = {
		@ComponentScan.Filter(type = FilterType.ANNOTATION, value = ExcludeFromSpringComponentScan.class) })
//name必须是Eureka中注册的名称 @RibbonClient不能再@ComponentScan所扫描的包及子包内
@RibbonClient(name = "spring-cloud-provider-user", configuration = CustomRibbonConfiguration.class)
@SpringBootApplication
public class ConsumerMovieRibbon {

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(ConsumerMovieRibbon.class, args);
	}

}
