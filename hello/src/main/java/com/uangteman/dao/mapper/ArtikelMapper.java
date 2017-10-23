package com.uangteman.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.uangteman.dao.PenulisDao;
import com.uangteman.model.Artikel;

public class ArtikelMapper implements RowMapper<Artikel> {
	
	private PenulisDao dao;
	
	public ArtikelMapper(PenulisDao dao) {
		this.dao = dao;
	}
	
	@Override
	public Artikel mapRow(ResultSet rs, int i) throws SQLException {
		Artikel artikel = new Artikel();
		artikel.setId(rs.getInt("id"));
		artikel.setTitle(rs.getString("title"));
		artikel.setTanggal(rs.getString("tanggal"));
		artikel.setPenulis(dao.getById(rs.getInt("penulis_id")));
		return artikel;
	}

}
