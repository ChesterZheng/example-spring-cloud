package com.example.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.cloud.entity.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class MovieController {

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/movie/{id}")
	@HystrixCommand(fallbackMethod = "findByIdFallack")
	public User findById(@PathVariable Long id) throws Exception {
		return this.restTemplate.getForObject("http://provider-user/simple/" + id, User.class);
	}

	/**
	 * 
	 * @Author ZhengXiaoChen
	 * @Description 断路器方法必须与原方法的参数和返回值一致
	 * @Date 2018年12月13日下午6:02:34
	 * @param id
	 * @return
	 * @throws Exception
	 * @ReturnType User
	 */
	public User findByIdFallack(Long id) throws Exception {
		User user = new User();
		user.setId(0L);
		return user;
	}

}
