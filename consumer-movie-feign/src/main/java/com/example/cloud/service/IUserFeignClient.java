package com.example.cloud.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.cloud.entity.User;

@FeignClient("spring-cloud-provider-user")
public interface IUserFeignClient {

	/*
	 * 使用Feign过程中的【坑】 1. 无法使用@GetMapping注解 必须使用@RequestMapping(value="xxx", method=
	 * RequestMethod.GET) 2.@PathVariable必须设置value属性
	 * 3.使用@RequestMapping(value="xxx", method=RequestMethod.GET) 并且方法的入参是对象时, 会报错,
	 * 默认会去找method=RequestMethod.POST对应的方法
	 */

	@RequestMapping(value = "/simple/{id}", method = RequestMethod.GET)
	public User findById(@PathVariable("id") Long id) throws Exception;

	@RequestMapping(value = "/post-user", method = RequestMethod.POST)
	public User postUser(@RequestBody User user) throws Exception;

	/**
	 * 
	 * @Author Chester_Zheng
	 * @Description 本方法是【错误示例】调用会报错 正确的方法在本方法下面
	 * @Date 2018年12月12日下午4:35:55
	 * @param user
	 * @return
	 * @throws Exception
	 * @ReturnType User
	 */
	@RequestMapping(value = "/get-user-failed", method = RequestMethod.GET)
	public User getUser(User user) throws Exception;

	/**
	 * 
	 * @Author Chester_Zheng
	 * @Description 本方法是【正确示例】调用成功 错误的方法在本方法上面
	 * @Date 2018年12月12日下午4:45:01
	 * @param id
	 * @param username
	 * @param name
	 * @return
	 * @throws Exception
	 * @ReturnType User
	 */
	@RequestMapping(value = "/get-user-success", method = RequestMethod.GET)
	public User getUser(@RequestParam("id") Long id, @RequestParam("username") String username,
			@RequestParam("name") String name) throws Exception;

}
