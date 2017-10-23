package com.uangteman.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.uangteman.model.Penulis;

public class PenulisMapper implements RowMapper<Penulis>{

	@Override
	public Penulis mapRow(ResultSet rs, int i) 
			throws SQLException {
		Penulis penulis = new Penulis();
		penulis.setId(rs.getInt("id"));
		penulis.setNama(rs.getString("nama"));
		return penulis;
	}

}
