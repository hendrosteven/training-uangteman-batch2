package com.uangteman.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.uangteman.dao.ArtikelDao;
import com.uangteman.model.Artikel;

@RestController
@RequestMapping("/artikel")
public class ArtikelController {

	@Autowired
	private ArtikelDao dao;

	private SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");

	@RequestMapping(method = RequestMethod.POST)
	public int insert(@RequestBody Artikel artikel) {
		artikel.setTanggal(fmt.format(new Date())); 
		return dao.insert(artikel);
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<Artikel> getAll() {
		return dao.getAll();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public Artikel getById(@PathVariable("id") int id) {
		return dao.getById(id);
	}
}
