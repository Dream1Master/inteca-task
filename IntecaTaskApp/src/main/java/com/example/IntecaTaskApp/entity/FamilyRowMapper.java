package com.example.IntecaTaskApp.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class FamilyRowMapper implements RowMapper<Family> {

	@Override
	public Family mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Family family = new Family();
		family.setId(rs.getInt("ID"));
		return family;
	}

}
