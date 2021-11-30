package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.AppConfig;

@RestController
public class ProfileController {

	@Autowired
	AppConfig appConfig;
	
	@GetMapping(value="/")
	public String getAppName() {
		return "App Name: " + appConfig.getAppName();
	}
}
