package com.example.cloud.service;

import org.springframework.stereotype.Component;

@Component
public class UserCustomFeignClientHystrixFallback implements IUserCustomFeignClient {

	@Override
	public String findEurekaByServiceName(String serviceName) throws Exception {
		return "haha";
	}

}
