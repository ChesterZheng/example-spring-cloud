package com.example.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.sidecar.EnableSidecar;

@EnableSidecar
@SpringBootApplication
public class SideCarApplication {

	/**
	 * 
	 * @Author Chester_Zheng
	 * @Description SpringCloud集成非java项目使用sidecar
	 * @Date 2019年2月25日下午4:52:49
	 * @param args
	 * @ReturnType void
	 */
	public static void main(String[] args) {
		SpringApplication.run(SideCarApplication.class, args);
	}

}
