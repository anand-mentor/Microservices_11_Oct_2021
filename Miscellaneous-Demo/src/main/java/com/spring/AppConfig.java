package com.spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AppConfig {

	@Value("${spring.application.name}")
	String appName;
	
	public String getAppName() {
		return this.appName;
	}
}
