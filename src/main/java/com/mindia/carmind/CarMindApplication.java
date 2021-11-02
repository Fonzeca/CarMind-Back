package com.mindia.carmind;

import com.mindia.carmind.user.pojo.UserHubConfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(UserHubConfig.class)
public class CarMindApplication{

	public static void main(String[] args) {
		SpringApplication.run(CarMindApplication.class, args);
	}
}
