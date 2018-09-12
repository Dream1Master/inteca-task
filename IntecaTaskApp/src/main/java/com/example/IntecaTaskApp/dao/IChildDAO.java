package com.example.IntecaTaskApp.dao;

import java.util.List;

import com.example.IntecaTaskApp.entity.Child;

public interface IChildDAO {
	
	List<Child> getAllChildren();
	Child getChildById(int childId);
    void addChild(Child child);
    void updateChild(Child child);
    void deleteChild(int childID);
    boolean childExists(String PESEL);
	List<Child> getChildsByFamilyId(int familyId);

}
