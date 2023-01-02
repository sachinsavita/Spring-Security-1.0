package com.learn.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="user")
public class User{
	
	@Id
	@Column(name="username")
	String userName;
	@Column(name="password")
	@JsonIgnore
	String password;
	@Column(name="email")
	String email;
	@Column(name="role")
	String role;
	
	public User() {}
	
	

	public User(String userName, String password, String email, String role) {
		super();
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.role = role;
	}



	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}



	@Override
	public String toString() {
		return "User [userName=" + userName + ", password=" + password + ", email=" + email + ", role=" + role + "]";
	}
	
	
	

}
