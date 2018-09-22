package de.seite50.rest;

import java.util.List;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.apache.meecrowave.jpa.api.Unit;

import de.seite50.models.Book;
import de.seite50.models.Library;
import de.seite50.models.User;

@Dependent
public class LibraryResource {

	@Inject
	@Unit(name = "seite50")
	EntityManager em;

	@Inject
	private LibraryService libService;

	public void setLibrary(Library library) {
		this.libService.setLibrary(library);
	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public Library getLibrary() {
		return libService.getLibrary();
	}

	@GET
	@Path("books")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Book> listBooks() {
		return libService.getLibrary().getBooks();
	}

	@POST
	@Path("books")
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response addBook(Book book, @Context UriInfo uriInfo) {
		libService.addBook(book);
		return Response.created(uriInfo.getAbsolutePath()).build();
	}

	@DELETE
	@Path("books/{bookId}")
	public Response deleteBook(@PathParam("bookId") String bookId) {
		libService.removeBook(bookId);
		return Response.accepted().build();
	}

	@GET
	@Path("librarians")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<User> listLibrarians() {
		return libService.getLibrarians();
	}

	@POST
	@Path("librarians")
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response addLibrarian(User librarian, @Context UriInfo uriInfo) {
		libService.addLibrarian(librarian);
		return Response.created(uriInfo.getAbsolutePath()).build();
	}

	@DELETE
	@Path("librarians/{librariansId}")
	public Response deleteLibrarian(@PathParam("librariansId") String librarianId) {
		libService.removeLibrarian(librarianId);
		return Response.accepted().build();
	}

	@GET
	@Path("guests")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<User> listGuests() {
		return libService.getGuests();
	}

	@POST
	@Path("guests")
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response addGuest(User guest, @Context UriInfo uriInfo) {
		libService.addGuest(guest);
		return Response.created(uriInfo.getAbsolutePath()).build();
	}

	@DELETE
	@Path("guests/{guestsId}")
	public Response deleteGuest(@PathParam("guestsId") String guestId) {
		libService.removeGuest(guestId);
		return Response.accepted().build();
	}
}
