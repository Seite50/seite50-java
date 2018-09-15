package de.seite50.rest;

import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import de.seite50.models.Book;

@Dependent
@ApplicationPath("api")
public class App extends Application{
	
	@Inject
	BooksService booksService;
	@PostConstruct
	public void startUp() {
		Book book = new Book();
		book.setName("Zahltag");
		booksService.addBook(book);
	}

}
