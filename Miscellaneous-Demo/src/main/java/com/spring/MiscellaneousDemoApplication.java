package com.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class MiscellaneousDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiscellaneousDemoApplication.class, args);
	}
	
	@Bean
	@Profile(value = "dev") //if(active_profile==dev)
	public AppConfig getAppConfigDev() {
		System.out.println("Inside getAppConfigDev() DEV");
		return new AppConfig();
	}
	
	@Bean
	@Profile(value = "prod") //if(active_profile==prod)
	public AppConfig getAppConfigProd() {
		System.out.println("Inside getAppConfigProd() PROD");
		return new AppConfig();
	}
}
