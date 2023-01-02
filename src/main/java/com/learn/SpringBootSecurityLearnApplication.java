package com.learn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.learn.models.User;
import com.learn.repo.UserRepository;

@SpringBootApplication
public class SpringBootSecurityLearnApplication implements CommandLineRunner{
	
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public static void main(String[] args) {
		
		SpringApplication.run(SpringBootSecurityLearnApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		String sql = "select username, password, email, role from user";
		List<User> users = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(User.class));

		users.forEach(System.out::println);

		System.out.println("All results printed");
		
		User user = new User();
		user.setUserName("Sachin");
		user.setPassword(this.bCryptPasswordEncoder.encode("pass12"));
		user.setEmail("sachin@mail.com");
		user.setRole("ROLE_admin");
		
		this.userRepository.save(user);
	
		
		User user1 = new User();
		user1.setUserName("Roshni");
		user1.setPassword(this.bCryptPasswordEncoder.encode("pass12"));
		user1.setEmail("roshni@mail.com");
		user1.setRole("ROLE_user");
		
		this.userRepository.save(user1);
		
		User user2 = new User();
		user2.setUserName("Rohan");
		user2.setPassword(this.bCryptPasswordEncoder.encode("pass12"));
		user2.setEmail("rohan@mail.com");
		user2.setRole("ROLE_user");
		
		this.userRepository.save(user2);
				
	}

}
