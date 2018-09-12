package com.example.IntecaTaskApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.IntecaTaskApp.dao.IChildDAO;
import com.example.IntecaTaskApp.entity.Child;

@Service
public class ChildService implements IChildService {
	
	@Autowired
	private IChildDAO childDAO;

	@Override
	public List<Child> getAllChildren() {
		// TODO Auto-generated method stub
		return childDAO.getAllChildren();
	}

	@Override
	public Child getChildById(int childId) {
		// TODO Auto-generated method stub
		Child obj = childDAO.getChildById(childId);
		return obj;
	}

	@Override
	public synchronized boolean addChild(Child child) {
		// TODO Auto-generated method stub
		if (childDAO.childExists(child.getPesel())) {
	          return false;
        } else {
        	childDAO.addChild(child);
	          return true;
        }
	}

	@Override
	public void updateChild(Child child) {
		// TODO Auto-generated method stub
		childDAO.updateChild(child);
	}

	@Override
	public void deleteChild(int childId) {
		// TODO Auto-generated method stub
		childDAO.deleteChild(childId);
	}

}
