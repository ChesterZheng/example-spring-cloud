package com.example.cloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.cloud.annotation.ExcludeFromSpringComponentScan;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

/**
 * 自定义Ribbon配置
 * 
 * @Author Chester_Zheng
 * @Date 2018年12月10日下午5:52:44
 * @Tags
 */
@Configuration
@ExcludeFromSpringComponentScan
public class CustomRibbonConfiguration {

	/**
	 * 
	 * @Author Chester_Zheng
	 * @Description 负载均衡策略采用【随机】
	 * @Date 2018年12月10日下午5:54:54
	 * @return
	 * @ReturnType IRule
	 */
	@Bean
	public IRule ribbonRule() {
		return new RandomRule();
	}
}
