package com.example.IntecaTaskApp.service;

import java.util.List;

import com.example.IntecaTaskApp.entity.Child;

public interface IChildService {
	
	List<Child> getAllChildren();
	Child getChildById(int childId);
    boolean addChild(Child child);
    void updateChild(Child child);
    void deleteChild(int childId);

}
