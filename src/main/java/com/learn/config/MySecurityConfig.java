package com.learn.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import com.learn.services.CustomUserDetailService;

@Configuration
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private CustomUserDetailService customUserDetailService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
		.and()
		.authorizeRequests()
		//.antMatchers("/home", "/login","/register").permitAll()
		.antMatchers("/signIn").permitAll()
		.antMatchers(HttpMethod.GET,"/public/**").hasRole("user")
		.antMatchers(HttpMethod.GET,"/users/**").hasRole("admin")
		.anyRequest()
		.authenticated()
		.and()
		.formLogin()
		.loginPage("/signIn")
		.loginProcessingUrl("/doLogin")
		.defaultSuccessUrl("/users/");   //for form based authentication
		
		//.httpBasic();  //for http request authentication    can use only one
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		
		
		auth.userDetailsService(customUserDetailService).passwordEncoder(passwordEncoder());
		
		
		
//		auth.inMemoryAuthentication()
//		.withUser("Sachin")
//		.password(this.passwordEncoder()
//		.encode("1234"))
//		.roles("admin");   //.roles("admin","user");
//		
//		auth.inMemoryAuthentication()
//		.withUser("Aswin")
//		.password(this.passwordEncoder()
//		.encode("4321"))
//		.roles("user");
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder()
	{
		//return NoOpPasswordEncoder.getInstance();
		return new BCryptPasswordEncoder(10);
	}
	
}
