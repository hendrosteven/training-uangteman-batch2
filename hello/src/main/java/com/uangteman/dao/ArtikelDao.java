package com.uangteman.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.uangteman.dao.mapper.ArtikelMapper;
import com.uangteman.model.Artikel;

@Component
public class ArtikelDao {

	@Autowired
	private JdbcTemplate jdbc;
	
	@Autowired
	private PenulisDao dao;
	
	public int insert(Artikel artikel){
		return jdbc.update("INSERT INTO tartikel(title,tanggal,content,penulis_id) "
				+ "VALUES(?,?,?,?)", 
				artikel.getTitle(),artikel.getTanggal(), artikel.getContent(),
				artikel.getPenulis().getId());
	}
	
	public List<Artikel> getAll(){
		return jdbc.query("SELECT id,title,tanggal,content, penulis_id FROM tartikel", 
					new ArtikelMapper(dao));
	}
	
	
	public Artikel getById(int id){
		return jdbc.queryForObject("SELECT id,title,tanggal,content, penulis_id FROM tartikel " 
				+ "WHERE id=?",
					new Object[]{id},
					new ArtikelMapper(dao));
	}
	
	public List<Artikel> getByPenulis(int penulisId){
		return jdbc.query("SELECT id,title,tanggal,content, penulis_id FROM tartikel "
				+ "WHERE penulis_id=?", 
				new Object[]{penulisId},
				new ArtikelMapper(dao));	
		
	}
	
	public List<Artikel> getByTanggal(String awal, String akhir){
		return jdbc.query("SELECT id,title,tanggal,content, penulis_id FROM tartikel "
				+ "WHERE tanggal>=? and tanggal<=?", 
				new Object[]{awal, akhir},
				new ArtikelMapper(dao));
	}
}
