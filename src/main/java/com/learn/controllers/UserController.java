package com.learn.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.models.User;
import com.learn.services.UserService;

@RestController
@RequestMapping("/users")
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//@PreAuthorize("hasRole('admin')")
public class UserController {

	@Autowired
	private UserService userService;

	// get all users
	@GetMapping("/")
	public List<User> getAllUsers() {
		return userService.getUsers();
	}

	// get single users
//	@PreAuthorize("hasRole('admin')")
	
	@GetMapping("/{userName}")
	public User getSingleUsers(@PathVariable String userName) {
		
		return this.userService.getSingleUser(userName);
	}
	
	@PostMapping("/")
	public User addUser(@RequestBody User user)
	{
		return this.userService.addUser(user);
	}

}
