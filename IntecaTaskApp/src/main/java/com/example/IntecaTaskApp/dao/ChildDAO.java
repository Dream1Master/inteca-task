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

@Transactional
@Repository
public class ChildDAO implements IChildDAO {
	
	@Autowired
    private JdbcTemplate jdbcTemplate;

	@Override
	public List<Child> getAllChildren() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM child";
        //RowMapper<Article> rowMapper = new BeanPropertyRowMapper<Article>(Article.class);
		RowMapper<Child> rowMapper = new ChildRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper);
	}

	@Override
	public Child getChildById(int childId) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM child WHERE ID = ?";
		RowMapper<Child> rowMapper = new BeanPropertyRowMapper<Child>(Child.class);
		Child child = jdbcTemplate.queryForObject(sql, rowMapper, childId);
		return child;
	}

	@Override
	public void addChild(Child child) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO child (ID, PESEL, FirstName, SecondName, BirthDay, Sex, FamilyId) values (?, ?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, child.getID(), child.getPesel(), child.getFirstName(), child.getSecondName(), child.getBirthDay(), child.getSex(), child.getFamilyId());
				
		//Fetch article id
		sql = "SELECT ID FROM child WHERE PESEL = ?";
		int childId = jdbcTemplate.queryForObject(sql, Integer.class, child.getPesel());
				
		//Set article id 
		child.setID(childId);
	}

	@Override
	public void updateChild(Child child) {
		// TODO Auto-generated method stub
		String sql = "UPDATE child SET PESEL=?, FirstName=?, SecondName=?, BirthDay=?, Sex=?, FamilyId=? WHERE ID=?";
		jdbcTemplate.update(sql, child.getPesel(), child.getFirstName(), child.getSecondName(), child.getBirthDay(), child.getSex(), child.getFamilyId(), child.getID());
	}

	@Override
	public void deleteChild(int childID) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM child WHERE ID=?";
		jdbcTemplate.update(sql, childID);
	}

	@Override
	public boolean childExists(String PESEL) {
		// TODO Auto-generated method stub
		String sql = "SELECT count(*) FROM child WHERE PESEL = ?";
		int count = jdbcTemplate.queryForObject(sql, Integer.class, PESEL);
		if(count == 0) {
    		        return false;
		} else {
			return true;
		}
	}
	
	@Override
	public List<Child> getChildsByFamilyId(int familyId) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM child WHERE FamilyId = ?";
        //RowMapper<Article> rowMapper = new BeanPropertyRowMapper<Article>(Article.class);
		RowMapper<Child> rowMapper = new ChildRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper, familyId);
	}

}
