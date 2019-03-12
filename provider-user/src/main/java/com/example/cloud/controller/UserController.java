package com.example.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.cloud.entity.User;
import com.example.cloud.service.IUserService;

@RestController
public class UserController {

	@Autowired
	private IUserService userService;

	@GetMapping("/simple/{id}")
	public User findById(@PathVariable Long id) throws Exception {
		return this.userService.findById(id);
	}

	@PostMapping("/post-user")
	public User postUser(@RequestBody User user) throws Exception {
		return user;
	}

	@GetMapping("/get-user-failed")
	public User getUser(User user) throws Exception {
		return user;
	}

	@GetMapping("/get-user-success")
	public User getUser(Long id, String username, String name) throws Exception {
		User user = new User();
		user.setId(id);
		user.setUsername(username);
		user.setName(name);
		return user;
	}

}
