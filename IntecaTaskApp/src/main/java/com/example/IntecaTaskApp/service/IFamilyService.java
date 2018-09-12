package com.example.IntecaTaskApp.service;

import java.util.List;

import com.example.IntecaTaskApp.entity.Family;

public interface IFamilyService {
	
	List<Family> getAllFamilies();

	Family getFamilyById(int familyId);

	boolean addFamily(Family family);

}
