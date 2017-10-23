package com.uangteman.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.uangteman.dao.mapper.PenulisMapper;
import com.uangteman.model.Penulis;

@Component
public class PenulisDao {

	@Autowired
	private JdbcTemplate jdbc;

	public int insert(Penulis penulis) {
		return jdbc.update("INSERT INTO tpenulis(nama) values(?)", 
				penulis.getNama());
	}

	public int update(Penulis penulis) {
		return jdbc.update("UPDATE tpenulis SET nama=? WHERE id=?", 
				penulis.getNama(), penulis.getId());
	}

	public List<Penulis> getAll() {
		return jdbc.query("SELECT id,nama FROM tpenulis", new PenulisMapper());
	}

	public Penulis getById(int id) {
		return jdbc.queryForObject("SELECT id,nama FROM tpenulis WHERE id=?", 
				new Object[] { id }, new PenulisMapper());
	}
}
