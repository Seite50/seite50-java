package de.seite50.models;

import java.util.UUID;

public class User {
	private String id;
	private String firstname;
	private String lastname;
	

	public void setId(String id) {
		this.id = id;
	}
	public String getId() {
		return this.id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
}
