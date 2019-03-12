package com.example.cloud.service;

import org.springframework.stereotype.Component;

import com.example.cloud.entity.User;

@Component
public class HystrixClientFallback implements IUserFeignClient {

	@Override
	public User findById(Long id) throws Exception {
		User user = new User();
		user.setId(-1L);
		return user;
	}

}
