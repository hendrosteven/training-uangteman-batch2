package com.uangteman.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.uangteman.dto.SearchForm;
import com.uangteman.repo.CategoryRepo;
import com.uangteman.repo.ProductRepo;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@Autowired
	private CategoryRepo repo;	
	@Autowired
	private ProductRepo pRepo;

	@RequestMapping(method=RequestMethod.GET)
	public String index(Model model){
		model.addAttribute("categories", repo.findAll());
		model.addAttribute("products", pRepo.findAll());
		model.addAttribute("form", new SearchForm());
		return "index";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="product/{id}")
	public String findByCategory(@PathVariable("id") Long id, Model model){
		model.addAttribute("categories", repo.findAll());
		model.addAttribute("products", pRepo.findByCategory(id));
		model.addAttribute("form", new SearchForm());
		return "index";
	}
	 
	@RequestMapping(method=RequestMethod.POST, value="search")
	public String findByCategory(SearchForm form, Model model){
		model.addAttribute("categories", repo.findAll());
		model.addAttribute("products", pRepo.findByName("%"+form.getName()+"%"));
		model.addAttribute("form", new SearchForm());
		return "index";
	}
}
