package com.uangteman.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.uangteman.dto.Messages;
import com.uangteman.dto.SearchForm;
import com.uangteman.entity.Product;
import com.uangteman.repo.CategoryRepo;
import com.uangteman.repo.ProductRepo;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductRepo pRepo;
	@Autowired
	private CategoryRepo cRepo;
	@Autowired
	private HttpSession session;

	@RequestMapping(method = RequestMethod.GET)
	public String insert(Model model) {
		if (session.getAttribute("loginUser") != null) {
			model.addAttribute("form", new SearchForm());
			model.addAttribute("product", new Product());
			model.addAttribute("categories", cRepo.findAll());
			return "input_product";
		} else {
			return "redirect:/"; 
		}
	} 

	@RequestMapping(method = RequestMethod.POST)
	public String save(Product product, Model model) {		
		product.setCategory(cRepo.findOne(product.getCategory().getId()));
		pRepo.save(product);
		Messages msg = new Messages();	
		msg.setType(Messages.MessageType.INFO);
		msg.setMessage("Product saved");
		session.setAttribute("info", msg);
		return "redirect:/product";
	}
}
