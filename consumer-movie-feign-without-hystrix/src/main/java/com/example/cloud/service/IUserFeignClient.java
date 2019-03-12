package com.example.cloud.service;

import org.springframework.cloud.netflix.feign.FeignClient;

import com.example.cloud.config.CustomFeignConfiguration1;
import com.example.cloud.entity.User;

import feign.Param;
import feign.RequestLine;

@FeignClient(name = "spring-cloud-provider-user", configuration = CustomFeignConfiguration1.class, fallback = UserFeignClientFallback.class)
public interface IUserFeignClient {

	@RequestLine("GET /simple/{id}")
	public User findById(@Param("id") Long id) throws Exception;

}
