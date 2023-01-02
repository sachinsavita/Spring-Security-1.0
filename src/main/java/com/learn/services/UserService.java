package com.learn.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.learn.models.User;


@Service
public class UserService {
	
	
	List<User> list = new ArrayList<>();

	public UserService() {
		list.add(new User("Sachin","pass123","sachin@mail.com","admin"));
		list.add(new User("Aswin","pass123","aswin@mail.com","user"));
	}
	
	//get all users
	public List<User> getUsers()
	{
		return this.list;	
	}
	
	//get single user 
	public User getSingleUser(String userName)
	{
		return this.list.stream().filter((user)->user.getUserName().equals(userName)).findAny().orElse(null);
	}
	
	//add user
	public User addUser(User user)
	{
		this.addUser(user);
		return user;
	}

}
