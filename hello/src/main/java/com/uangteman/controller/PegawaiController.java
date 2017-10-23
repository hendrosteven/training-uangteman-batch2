package com.uangteman.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.uangteman.dao.PenulisDao;
import com.uangteman.model.Penulis;

@RestController
@RequestMapping("/penulis")
public class PegawaiController {

	@Autowired
	private PenulisDao dao;	
	
	@RequestMapping(method=RequestMethod.POST)
	public int insert(@RequestBody Penulis penulis){
		return dao.insert(penulis);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Penulis> getAll(){
		return dao.getAll();
	}
	
	@RequestMapping(method=RequestMethod.PUT)
	public int update(@RequestBody Penulis penulis){
		return dao.update(penulis);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	public Penulis getById(@PathVariable("id") int id){
		return dao.getById(id);
	}
}
