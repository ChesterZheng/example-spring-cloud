package com.example.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.cloud.entity.User;

@RestController
public class MovieController {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private LoadBalancerClient loadBalancerClient;

	@GetMapping("/movie/{id}")
	public User findById(@PathVariable Long id) throws Exception {
		return this.restTemplate.getForObject("http://provider-user/simple/" + id, User.class);
	}

	@GetMapping("/test")
	public String test() {
		ServiceInstance choose = loadBalancerClient.choose("spring-cloud-provider-user");
		System.out.println(choose.getHost() + ":" + choose.getPort() + ":" + choose.getServiceId());
		return "1";
	}

}
