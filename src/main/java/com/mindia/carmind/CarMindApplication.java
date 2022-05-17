package com.mindia.carmind;

import com.mindia.carmind.usuario.pojo.userHub.UserHubConfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableConfigurationProperties(UserHubConfig.class)
@EnableScheduling
public class CarMindApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarMindApplication.class, args);
	}
}
