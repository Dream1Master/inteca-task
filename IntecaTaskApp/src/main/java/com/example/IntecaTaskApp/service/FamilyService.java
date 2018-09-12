package com.example.IntecaTaskApp.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.IntecaTaskApp.dao.IFamilyDAO;
import com.example.IntecaTaskApp.entity.Child;
import com.example.IntecaTaskApp.entity.Family;
import com.example.IntecaTaskApp.entity.Father;

@Service
public class FamilyService implements IFamilyService {
	
	@Autowired
	private IFamilyDAO familyDAO;

	@Override
	public List<Family> getAllFamilies() {
		// TODO Auto-generated method stub
		return familyDAO.getAllFamilies();
	}
	
	@Override
	public Family getFamilyById(int familyId) {
		// TODO Auto-generated method stub
		return familyDAO.getFamilyById(familyId);
	}
	
	@Override
	public synchronized boolean addFamily(Family family) {
		// TODO Auto-generated method stub
        familyDAO.addFamily(family);
	    return true;
	}

}
