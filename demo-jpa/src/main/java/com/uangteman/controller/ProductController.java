package com.uangteman.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.uangteman.dto.SearchForm;
import com.uangteman.dto.SearchPriceForm;
import com.uangteman.entity.Category;
import com.uangteman.entity.Product;
import com.uangteman.repo.ProductRepo;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductRepo repo;

	@RequestMapping(method = RequestMethod.POST)
	public Product insertOrUpdate(@RequestBody Product product) {
		return repo.save(product);
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<Product> findAll() {
		return repo.findAll();
	}

	@RequestMapping(method = RequestMethod.POST, value = "/byprice")
	public List<Product> findByPriceRange(@RequestBody SearchPriceForm form) {
		return repo.findByPriceRange(form.getMin(), form.getMax());
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/bycategory")
	public List<Product> findByCategory(@RequestBody Category category) {
		return repo.findByCategory(category);
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/byname")
	public List<Product> findByName(@RequestBody SearchForm form) {
		return repo.findByName("%"+form.getName()+"%");
	}
	
	
}
