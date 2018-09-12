package com.example.IntecaTaskApp.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ChildRowMapper implements RowMapper<Child> {

	@Override
	public Child mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Child father = new Child();
		father.setID(rs.getInt("ID"));
		father.setPesel(rs.getString("PESEL"));
		father.setFirstName(rs.getString("FirstName"));
		father.setSecondName(rs.getString("SecondName"));
		father.setBirthDay(rs.getDate("BirthDay"));
		father.setSex(rs.getString("Sex"));
		father.setFamilyId(rs.getInt("FamilyId"));
		return father;
	}

}
