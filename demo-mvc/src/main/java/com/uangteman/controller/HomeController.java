package com.uangteman.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.uangteman.repo.CategoryRepo;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@Autowired
	private CategoryRepo repo;	

	@RequestMapping(method=RequestMethod.GET)
	public String index(Model model){
		model.addAttribute("categories", repo.findAll());
		return "index";
	}
}
