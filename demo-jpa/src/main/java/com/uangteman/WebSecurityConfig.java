package com.uangteman;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;

import com.uangteman.service.UserService;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserService userService;
	
	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth)
		throws Exception{
		auth.userDetailsService(userService);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.addFilterBefore(new CorsConfig(), 
				ChannelProcessingFilter.class);
		http.authorizeRequests()
		.antMatchers("/").permitAll()
		.antMatchers(HttpMethod.POST, "/user/register").permitAll()
		.antMatchers(HttpMethod.POST, "/user/login").permitAll()
		.antMatchers(HttpMethod.GET, "/product").permitAll()
		.antMatchers(HttpMethod.POST, "/product/byname").permitAll()
		.antMatchers(HttpMethod.GET, "/category").permitAll()
		.anyRequest().fullyAuthenticated()
		.and().httpBasic().and().csrf().disable();
	}
}
