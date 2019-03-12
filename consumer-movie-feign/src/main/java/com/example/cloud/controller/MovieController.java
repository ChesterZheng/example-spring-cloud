package com.example.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.cloud.entity.User;
import com.example.cloud.service.IUserFeignClient;

@RestController
public class MovieController {

	@Autowired
	private IUserFeignClient userFeignClient;

	@GetMapping("/movie/{id}")
	public User findById(@PathVariable Long id) throws Exception {
		return this.userFeignClient.findById(id);
	}

	@GetMapping("/test-post")
	public User testPost(User user) throws Exception {
		return this.userFeignClient.postUser(user);
	}

	@GetMapping("/test-get-failed")
	public User testGet(User user) throws Exception {
		return this.userFeignClient.getUser(user);
	}

	@GetMapping("/test-get-success")
	public User testGet(Long id, String username, String name) throws Exception {
		return this.userFeignClient.getUser(id, username, name);
	}
}
