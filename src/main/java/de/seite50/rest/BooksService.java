package de.seite50.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import javax.enterprise.context.ApplicationScoped;

import de.seite50.models.Book;

@ApplicationScoped
public class BooksService {

	ConcurrentHashMap<String, Book> books = new ConcurrentHashMap<>();
	
	public List<Book> getBooks() {
		return new ArrayList<>(books.values());
	}
	
	public String addBook(Book book) {
		UUID id = UUID.randomUUID();
		books.put(id.toString(), book);
		return id.toString();
	}
}
