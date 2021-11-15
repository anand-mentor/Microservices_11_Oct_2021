package com.spring;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SampleController {

	private static List<User> users = new ArrayList<User>();
	static {
		users.add(new User("Tom", "New York"));
		users.add(new User("Jerry", "Washington"));
		users.add(new User("Ivan", "London"));
	}
	@GetMapping(value="contactus")
	public String contactUs(Model model) {
		model.addAttribute("users", users);
		return "contactus";
	}
}

