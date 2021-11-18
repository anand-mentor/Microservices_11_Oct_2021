package com.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@GetMapping(value="/all")
	public String helloAll() {
		return "Hello All";
	}
	@GetMapping(value="/user")
	public String helloUser() {
		return "Hello User";
	}
	@GetMapping(value="/admin")
	public String helloAdmin() {
		return "Hello Admin";
	}
}
