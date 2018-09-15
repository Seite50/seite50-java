package de.seite50.rest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import de.seite50.models.Author;
import de.seite50.models.Book;

@Dependent
@ApplicationPath("api")
public class App extends Application {

	@Inject
	BooksService booksService;

	@Inject
	AuthorsService authorsService;

	@PostConstruct
	public void startUp() {

		Author author = new Author();
		author.setGivenname("Petros");
		author.setSurname("Markaris");
		String authorId = authorsService.addAuthor(author);

		Book book = new Book();
		book.setName("Zahltag");
		book.setIsbn("9783257242683");
		book.setAuthors(Arrays.asList(authorsService.getAuthor(authorId)));
		booksService.addBook(book);
	}

}
