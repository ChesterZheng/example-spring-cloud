package com.example.cloud.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.example.cloud.entity.User;

import feign.hystrix.FallbackFactory;

@Component
public class HystrixClientFallbackFactory implements FallbackFactory<IUserFeignClient> {

	private static final Logger LOGGER = LoggerFactory.getLogger(HystrixClientFallbackFactory.class);

	@Override
	public IUserFeignClient create(Throwable cause) {
		HystrixClientFallbackFactory.LOGGER.info("fallback; reason was: {}", cause.getMessage());
		return new UserFeignClientWithHystrixFactory() {
			@Override
			public User findById(Long id) throws Exception {
				User user = new User();
				user.setId(-1L);
				return user;
			}
		};
	}

}
