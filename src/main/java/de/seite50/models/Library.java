package de.seite50.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Library {
	private String id;
	private String name;
	private List<Book> books = new ArrayList<>();
	private List<User> librarians = new ArrayList<>();
	private List<User> guests = new ArrayList<>();
	
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
	public void removeBook(String bookId) {
		this.books.remove(bookId);
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
	public void removeLibrarian(String librarianId) {
		this.librarians.remove(librarianId);
	}
	public List<User> getGuests() {
		return guests;
	}
	public void setGuests(List<User> guests) {
		this.guests = guests;
	}
	public void addGuest(User guest){
		this.guests.add(guest);
	}
	public void removeGuest(String guestId) {
		this.guests.remove(guestId);
	}
}
