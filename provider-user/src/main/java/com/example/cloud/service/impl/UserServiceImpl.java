package com.example.cloud.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cloud.dao.IUserRepository;
import com.example.cloud.entity.User;
import com.example.cloud.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserRepository userRepository;

	@Override
	public User findById(Long id) throws Exception {
		return this.userRepository.findOne(id);
	}

}
