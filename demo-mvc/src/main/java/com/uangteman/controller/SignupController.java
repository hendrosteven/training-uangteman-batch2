package com.uangteman.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.uangteman.dto.SearchForm;
import com.uangteman.entity.User;
import com.uangteman.repo.UserRepo;

@Controller
@RequestMapping("/signup")
public class SignupController {

	@Autowired
	private UserRepo repo;
	
	@RequestMapping(method=RequestMethod.GET)
	public String register(Model model){
		model.addAttribute("user", new User());
		model.addAttribute("form", new SearchForm());
		return "signup";
	}
	
	
	@RequestMapping(method=RequestMethod.POST)
	public String signup(User user, Model model){
		repo.save(user);
		return "redirect:/";
	}
	
}
