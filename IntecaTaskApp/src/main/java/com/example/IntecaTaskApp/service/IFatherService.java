package com.example.IntecaTaskApp.service;

import java.util.List;

import com.example.IntecaTaskApp.entity.Child;
import com.example.IntecaTaskApp.entity.Father;

public interface IFatherService {
	
	List<Father> getAllFathers();
	Father getFatherById(int fatherId);
    boolean addFather(Father father);
    void updateFather(Father father);
    void deleteFather(int fatherId);
	List<Child> getChilds(int familyId);

}
