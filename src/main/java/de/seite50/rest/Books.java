package de.seite50.rest;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import de.seite50.configuration.Defaults;
import de.seite50.models.Book;

@Path("books")
@ApplicationScoped
public class Books {
	
	@Inject
	private Defaults defaults;
	
	@Inject
	private BooksService booksService;

	@GET
	@Path("/info")
	public String info() {
		return defaults.getName();
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public List<Book> listBooks() {
		return booksService.getBooks();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addBook(Book book, @Context UriInfo uriInfo) {
		String id = booksService.addBook(book);
		return Response.created(uriInfo.getAbsolutePath()).build();
	}
	
}
