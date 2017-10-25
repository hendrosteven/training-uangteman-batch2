package com.uangteman.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.uangteman.dto.Messages;
import com.uangteman.dto.SearchForm;
import com.uangteman.entity.User;
import com.uangteman.repo.UserRepo;

@Controller
@RequestMapping("/signin")
public class SigninController {

	@Autowired
	private UserRepo repo;
	
	@Autowired
	private HttpSession session;
	
	@RequestMapping(method=RequestMethod.GET)
	public String singin(Model model){
		model.addAttribute("user", new User());
		model.addAttribute("form", new SearchForm());
		return "signin";
	}
	
	
	@RequestMapping(method=RequestMethod.POST)
	public String signinProcess(User user, Model model){
		User loginUser = repo
				.findByEmailAndPassword(user.getEmail(), 
						user.getPassword());
		if(loginUser!=null){
			session.setAttribute("loginUser", loginUser);
			return "redirect:/";
		}else{
			//add pesan error
			Messages msg = new Messages();	
			msg.setType(Messages.MessageType.ERROR);
			msg.setMessage("Invalid email or password");
			session.setAttribute("error", msg);
			return "redirect:/signin";
		}
		
	}
	
}
