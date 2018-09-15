package de.seite50.models;

import java.util.Collections;
import java.util.List;

public class Book {

	private String name;
	private String id;
	private List<Author> authors = Collections.emptyList();
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	public String getId() {
		return id;
	}
	
	public List<Author> getAuthors() {
		return authors;
	}
	
	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}
}
