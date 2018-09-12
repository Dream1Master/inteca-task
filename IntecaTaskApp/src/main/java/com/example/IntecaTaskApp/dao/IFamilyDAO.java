package com.example.IntecaTaskApp.dao;

import java.util.List;

import com.example.IntecaTaskApp.entity.Family;

public interface IFamilyDAO {
	
	List<Family> getAllFamilies();
	void addFamily(Family family);
	Family getFamilyById(int familyId);

}
