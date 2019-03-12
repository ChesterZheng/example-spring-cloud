package com.example.cloud.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.cloud.entity.User;

@FeignClient(name = "provider-user", fallback = HystrixClientFallback.class)
public interface IUserFeignClient {

	/*
	 * 使用Feign过程中的【坑】 
	 * 1. 无法使用@GetMapping注解 必须使用@RequestMapping(value="xxx", method= RequestMethod.GET) 
	 * 2.@PathVariable必须设置value属性
	 * 3.使用@RequestMapping(value="xxx", method=RequestMethod.GET) 并且方法的入参是对象时, 会报错,
	 * 默认会去找method=RequestMethod.POST对应的方法
	 */

	@RequestMapping(value = "/simple/{id}", method = RequestMethod.GET)
	public User findById(@PathVariable("id") Long id) throws Exception;

}

