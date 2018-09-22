package de.seite50.models;

import java.util.UUID;

import javax.enterprise.context.Dependent;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Dependent
public class Author {

	private String lastname;
	private String firstname;

	@Id
	private String id;

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String surname) {
		this.lastname = surname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String givenname) {
		this.firstname = givenname;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Author other = (Author) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Author() {
		this.id = UUID.randomUUID().toString();
	}
}
