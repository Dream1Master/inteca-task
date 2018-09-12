package com.example.IntecaTaskApp.entity;

import java.sql.Date;

public class Father {
	
	private int ID;  
    private String pesel;
	private String firstName;
	private String secondName;
	private Date birthDay;
	private int familyId;
	
	public void setID(int iD) {
		ID = iD;
	}
	
	public int getID() {
		return ID;
	}
	
	public void setPESEL(String pESEL) {
		pesel = pESEL;
	}
	
	public String getPESEL() {
		return pesel;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}
	
	public String getSecondName() {
		return secondName;
	}
	
	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}
	
	public Date getBirthDay() {
		return birthDay;
	}

	public int getFamilyId() {
		return familyId;
	}

	public void setFamilyId(int familyId) {
		this.familyId = familyId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pesel == null) ? 0 : pesel.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Father))
			return false;
		Father other = (Father) obj;
		if (pesel == null) {
			if (other.getPESEL() != null)
				return false;
		} else if (!pesel.equals(other.getPESEL()))
			return false;
		return true;
	}

}
