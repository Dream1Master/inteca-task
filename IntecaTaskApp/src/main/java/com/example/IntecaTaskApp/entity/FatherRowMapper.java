package com.example.IntecaTaskApp.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class FatherRowMapper implements RowMapper<Father> {

	@Override
	public Father mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Father father = new Father();
		father.setID(rs.getInt("ID"));
		father.setPESEL(rs.getString("PESEL"));
		father.setFirstName(rs.getString("FirstName"));
		father.setSecondName(rs.getString("SecondName"));
		father.setBirthDay(rs.getDate("BirthDay"));
		father.setFamilyId(rs.getInt("FamilyId"));
		return father;
	}

}
