package com.uangteman.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.uangteman.dto.LoginForm;
import com.uangteman.entity.User;
import com.uangteman.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.POST, value = "/register")
	public User register(@RequestBody User user) throws Exception {
		return userService.register(user);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/login")
	public User login(@RequestBody LoginForm form) throws Exception {
		return userService.login(form.getEmail(), form.getPassword());
	}

}
