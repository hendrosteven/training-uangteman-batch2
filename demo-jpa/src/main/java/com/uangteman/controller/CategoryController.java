package com.uangteman.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.uangteman.dto.SearchForm;
import com.uangteman.entity.Category;
import com.uangteman.repo.CategoryRepo;

@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryRepo repo;

	@RequestMapping(method = RequestMethod.POST)
	public Category save(@RequestBody Category category) {
		return repo.save(category);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/search")
	public List<Category> findByName(@RequestBody SearchForm form) {
		return repo.findByNameIgnoringCase(form.getName());
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Category> findAll(){
		return repo.findAll();

	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/like")
	public List<Category> findByNameLike(@RequestBody SearchForm form) {
		return repo.findByName("%"+form.getName()+"%");
	}
}
