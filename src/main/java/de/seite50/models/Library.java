package de.seite50.models;

import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Library {

	@Id
	private String id;
	private String name;

	@ManyToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST })
	private List<Book> books;

	@ManyToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST })
	private List<User> librarians;

	@ManyToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST })
	private List<User> guests;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public void addBook(Book book) {
		this.books.add(book);
	}

	public void removeBook(Book book) {
		this.books.remove(book);
	}

	public List<User> getLibrarians() {
		return librarians;
	}

	public void setLibrarians(List<User> librarians) {
		this.librarians = librarians;
	}

	public void addLibrarian(User librarian) {
		this.librarians.add(librarian);
	}

	public void removeLibrarian(User librarian) {
		this.librarians.remove(librarian);
	}

	public List<User> getGuests() {
		return guests;
	}

	public void setGuests(List<User> guests) {
		this.guests = guests;
	}

	public void addGuest(User guest) {
		this.guests.add(guest);
	}

	public void removeGuest(User guest) {
		this.guests.remove(guest);
	}

	public Library() {
		this.id = UUID.randomUUID().toString();
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
		Library other = (Library) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
