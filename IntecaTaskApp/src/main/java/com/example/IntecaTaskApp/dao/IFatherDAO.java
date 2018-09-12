package com.example.IntecaTaskApp.dao;

import java.util.List;

import com.example.IntecaTaskApp.entity.Child;
import com.example.IntecaTaskApp.entity.Father;

public interface IFatherDAO {
	
	List<Father> getAllFathers();
	Father getFatherById(int fatherId);
    void addFather(Father father);
    void updateFather(Father father);
    void deleteFather(int fatherID);
    boolean fatherExists(String PESEL);
	List<Child> fatherChilds(int familyID);
	Father getFatherByFamilyId(int familyId);

}
