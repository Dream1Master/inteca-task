package com.example.IntecaTaskApp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.IntecaTaskApp.entity.Child;
import com.example.IntecaTaskApp.entity.ChildRowMapper;
import com.example.IntecaTaskApp.entity.Father;
import com.example.IntecaTaskApp.entity.FatherRowMapper;

@Transactional
@Repository
public class FatherDAO implements IFatherDAO {
	
	@Autowired
    private JdbcTemplate jdbcTemplate;

	@Override
	public List<Father> getAllFathers() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM father";
        //RowMapper<Article> rowMapper = new BeanPropertyRowMapper<Article>(Article.class);
		RowMapper<Father> rowMapper = new FatherRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper);
	}

	@Override
	public Father getFatherById(int fatherId) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM father WHERE ID = ?";
		RowMapper<Father> rowMapper = new BeanPropertyRowMapper<Father>(Father.class);
		Father father = jdbcTemplate.queryForObject(sql, rowMapper, fatherId);
		return father;
	}

	@Override
	public void addFather(Father father) {
		// TODO Auto-generated method stub
		//Add article
		String sql = "INSERT INTO father (ID, PESEL, FirstName, SecondName, BirthDay, FamilyId) values (?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, father.getID(), father.getPESEL(), father.getFirstName(), father.getSecondName(), father.getBirthDay(), father.getFamilyId());
				
		//Fetch article id
		sql = "SELECT ID FROM father WHERE PESEL = ?";
		int fatherId = jdbcTemplate.queryForObject(sql, Integer.class, father.getPESEL());
				
		//Set article id 
		father.setID(fatherId);
	}

	@Override
	public void updateFather(Father father) {
		// TODO Auto-generated method stub
		String sql = "UPDATE father SET PESEL=?, FirstName=?, SecondName=?, BirthDay=?, FamilyId=? WHERE ID=?";
		jdbcTemplate.update(sql, father.getPESEL(), father.getFirstName(), father.getSecondName(), father.getBirthDay(), father.getFamilyId(), father.getID());
	}

	@Override
	public void deleteFather(int fatherID) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM father WHERE ID=?";
		jdbcTemplate.update(sql, fatherID);
	}

	@Override
	public boolean fatherExists(String PESEL) {
		// TODO Auto-generated method stub
		String sql = "SELECT count(*) FROM father WHERE PESEL = ?";
		int count = jdbcTemplate.queryForObject(sql, Integer.class, PESEL);
		if(count == 0) {
    		        return false;
		} else {
			return true;
		}
	}
	
	@Override
	public List<Child> fatherChilds(int familyID) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM child WHERE FamilyId = ?";
		RowMapper<Child> rowMapper = new ChildRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper, familyID);
	}
	
	@Override
	public Father getFatherByFamilyId(int familyId) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM father WHERE FamilyId = ?";
		RowMapper<Father> rowMapper = new BeanPropertyRowMapper<Father>(Father.class);
		Father father = jdbcTemplate.queryForObject(sql, rowMapper, familyId);
		return father;
	}

}
