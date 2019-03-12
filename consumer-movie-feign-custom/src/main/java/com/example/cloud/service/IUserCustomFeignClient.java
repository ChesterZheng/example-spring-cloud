package com.example.cloud.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.cloud.config.CustomFeignConfiguration2;

@FeignClient(name = "xxxx", url = "http://localhost:8761/", configuration = CustomFeignConfiguration2.class)
public interface IUserCustomFeignClient {

	@RequestMapping(value = "/eureka/apps/{serviceName}")
	public String findEurekaByServiceName(@PathVariable("serviceName") String serviceName) throws Exception;

}
