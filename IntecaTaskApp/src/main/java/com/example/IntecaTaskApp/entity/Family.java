package com.example.IntecaTaskApp.entity;

import java.util.List;

public class Family {
	
	private int id;
	private Father father;
	private List<Child> childs;
	
	public Father getFather() {
		return father;
	}
	
	public void setFather(Father father) {
		this.father = father;
	}

	public List<Child> getChilds() {
		return childs;
	}

	public void setChilds(List<Child> childs) {
		this.childs = childs;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
