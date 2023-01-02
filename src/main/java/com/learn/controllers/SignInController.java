package com.learn.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SignInController {

	@GetMapping("/signIn")
	public String signIn()
	{
		return "login.html";
	}
}
