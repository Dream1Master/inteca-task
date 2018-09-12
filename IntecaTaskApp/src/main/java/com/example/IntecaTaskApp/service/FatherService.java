package com.example.IntecaTaskApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.IntecaTaskApp.dao.IFatherDAO;
import com.example.IntecaTaskApp.entity.Child;
import com.example.IntecaTaskApp.entity.Father;

@Service
public class FatherService implements IFatherService {
	
	@Autowired
	private IFatherDAO fatherDAO;

	@Override
	public List<Father> getAllFathers() {
		// TODO Auto-generated method stub
		return fatherDAO.getAllFathers();
	}

	@Override
	public Father getFatherById(int fatherId) {
		// TODO Auto-generated method stub
		Father obj = fatherDAO.getFatherById(fatherId);
		return obj;
	}

	@Override
	public synchronized boolean addFather(Father father) {
		// TODO Auto-generated method stub
		if (fatherDAO.fatherExists(father.getPESEL())) {
	          return false;
          } else {
        	  fatherDAO.addFather(father);
	          return true;
          }
	}

	@Override
	public void updateFather(Father father) {
		// TODO Auto-generated method stub
		fatherDAO.updateFather(father);
	}

	@Override
	public void deleteFather(int fatherId) {
		// TODO Auto-generated method stub
		fatherDAO.deleteFather(fatherId);
	}

	@Override
	public List<Child> getChilds(int familyId) {
		// TODO Auto-generated method stub
		return fatherDAO.fatherChilds(familyId);
	}

}
