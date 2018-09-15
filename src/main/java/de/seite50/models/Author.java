package de.seite50.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Author {
	
	private String surname;
	private String givenname;
	
	@Id
	private String id;
	
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getGivenname() {
		return givenname;
	}
	public void setGivenname(String givenname) {
		this.givenname = givenname;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

}
