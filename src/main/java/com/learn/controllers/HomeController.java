package com.learn.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class HomeController {

	@GetMapping("/home")
	public String home()
	{
		return "Welcome to the Home Page";
	}
	
	@GetMapping("/login")
	public String login()
	{
		return "Welcome to the Login Page";
	}
	
	@GetMapping("/register")
	public String register()
	{
		return "Welcome to the Register Page";
	}
}
