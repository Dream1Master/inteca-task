package com.example.IntecaTaskApp.entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

public class FamilyExtractor implements ResultSetExtractor<Map<Father, List<Child>>> {

	@Override
	public Map<Father, List<Child>> extractData(ResultSet rs) throws SQLException, DataAccessException {
		// TODO Auto-generated method stub
		Map<Father, List<Child>> data = new LinkedHashMap<>();
        while (rs.next()) {
        	Father father = new Father();
    		father.setID(rs.getInt("father_id"));
    		father.setPESEL(rs.getString("father_pesel"));
    		father.setFirstName(rs.getString("father_first_name"));
    		father.setSecondName(rs.getString("father_second_name"));
    		father.setBirthDay(rs.getDate("father_birth_day"));
    		father.setFamilyId(rs.getInt("father_family_id"));
            data.putIfAbsent(father, new ArrayList<>());
            Child child = new Child();
            child.setID(rs.getInt("child_id"));
            child.setPesel(rs.getString("child_pesel"));
            child.setFirstName(rs.getString("child_first_name"));
            child.setSecondName(rs.getString("child_second_name"));
            child.setSex(rs.getString("child_sex"));
            child.setBirthDay(rs.getDate("child_birth_day"));
            child.setFamilyId(rs.getInt("child_family_id"));
            data.get(father).add(child);
        }
        return data;
	}

}
