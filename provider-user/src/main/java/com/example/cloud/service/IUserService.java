package com.example.cloud.service;

import com.example.cloud.entity.User;

public interface IUserService {

	public User findById(Long id) throws Exception;

}
