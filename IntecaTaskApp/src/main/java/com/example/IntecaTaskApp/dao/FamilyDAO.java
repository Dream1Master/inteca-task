package com.example.IntecaTaskApp.dao;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.IntecaTaskApp.entity.Child;
import com.example.IntecaTaskApp.entity.Family;
import com.example.IntecaTaskApp.entity.FamilyExtractor;
import com.example.IntecaTaskApp.entity.Father;

@Transactional
@Repository
public class FamilyDAO implements IFamilyDAO {
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private IFatherDAO fatherDAO;
	
	@Autowired
	private IChildDAO childDAO;

	@Override
	public List<Family> getAllFamilies() {
		// TODO Auto-generated method stub
		String sql = "SELECT " + 
			    "f.ID AS father_id, " +
			    "f.FirstName AS father_first_name, " +
			    "f.SecondName AS father_second_name, " +
			    "f.PESEL AS father_pesel, " +
			    "f.BirthDay AS father_birth_day, " +
			    "f.FamilyId AS father_family_id, " +
			    "c.ID AS child_id, " +
			    "c.FirstName AS child_first_name, " +
			    "c.SecondName AS child_second_name, " +
			    "c.PESEL AS child_pesel, " +
			    "c.Sex AS child_sex, " +
			    "c.BirthDay AS child_birth_day, " +
			    "c.FamilyId AS child_family_id " +
			"FROM " +
			    "child c " +
			        "LEFT JOIN " +
			    "father f ON c.FamilyId = f.FamilyId " +
			"ORDER BY f.FirstName";
        //RowMapper<Article> rowMapper = new BeanPropertyRowMapper<Article>(Article.class);
		ResultSetExtractor<Map<Father, List<Child>>> extractor = new FamilyExtractor();
		Map<Father, List<Child>> resultSet = this.jdbcTemplate.query(sql, extractor);
		List<Family> data = new ArrayList<>();
		for(Father f : resultSet.keySet()) {
			Family family = new Family();
			family.setId(f.getFamilyId());
			family.setFather(f);
			family.setChilds(resultSet.get(f));
			data.add(family);
		}
		return data;
	}
	
	@Override
	public void addFamily(Family family) {
		// TODO Auto-generated method stub
		//Add article
		String hash = new RandomString(20).nextString();
		String sql = "INSERT INTO family (hash) values(?)";
		jdbcTemplate.update(sql, hash);
				
		//Fetch article id
		sql = "SELECT ID FROM family WHERE hash = ?";
		int familyId = jdbcTemplate.queryForObject(sql, Integer.class, hash);
				
		//Set article id 
		family.setId(familyId);
	}
	
	@Override
	public Family getFamilyById(int familyId) {
		// TODO Auto-generated method stub
		Father father = fatherDAO.getFatherByFamilyId(familyId);
        //RowMapper<Article> rowMapper = new BeanPropertyRowMapper<Article>(Article.class);
		List<Child> childs = childDAO.getChildsByFamilyId(familyId);
		Family family = new Family();
		family.setFather(father);
		family.setChilds(childs);
		return family;
	}
	
	private static class RandomString {

	    /**
	     * Generate a random string.
	     */
	    public String nextString() {
	        for (int idx = 0; idx < buf.length; ++idx)
	            buf[idx] = symbols[random.nextInt(symbols.length)];
	        return new String(buf);
	    }

	    private final static String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	    private final static String lower = upper.toLowerCase(Locale.ROOT);

	    private final static String digits = "0123456789";

	    private final static String alphanum = upper + lower + digits;

	    private final Random random;

	    private final char[] symbols;

	    private final char[] buf;

	    public RandomString(int length, Random random, String symbols) {
	        if (length < 1) throw new IllegalArgumentException();
	        if (symbols.length() < 2) throw new IllegalArgumentException();
	        this.random = Objects.requireNonNull(random);
	        this.symbols = symbols.toCharArray();
	        this.buf = new char[length];
	    }

	    /**
	     * Create an alphanumeric string generator.
	     */
	    public RandomString(int length, Random random) {
	        this(length, random, alphanum);
	    }

	    /**
	     * Create an alphanumeric strings from a secure generator.
	     */
	    public RandomString(int length) {
	        this(length, new SecureRandom());
	    }

	    /**
	     * Create session identifiers.
	     */
	    public RandomString() {
	        this(21);
	    }

	}

}
