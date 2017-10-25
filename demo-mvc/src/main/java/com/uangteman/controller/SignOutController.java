package com.uangteman.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.uangteman.dto.SearchForm;

@Controller
@RequestMapping("/signout")
public class SignOutController {

	@Autowired
	private HttpSession session;
	
	@RequestMapping(method=RequestMethod.GET)
	public String singin(Model model){		
		session.invalidate();
		model.addAttribute("form", new SearchForm());
		return "redirect:/";
	}
}
