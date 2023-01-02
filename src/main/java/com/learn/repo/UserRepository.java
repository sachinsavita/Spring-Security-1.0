package com.learn.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.learn.models.User;

public interface UserRepository extends JpaRepository<User, String>{

	public User findByUserName(String username);

	
	
}
