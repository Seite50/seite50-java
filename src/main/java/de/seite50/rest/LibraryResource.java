package de.seite50.rest;

import java.util.List;

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

import de.seite50.models.Book;
import de.seite50.models.Library;
import de.seite50.models.User;

public class LibraryResource {
	private Library library;
	
	public LibraryResource(Library lib) {
		this.library = lib;
	}
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public Library getLibrary() {
		return library;
	}

	public void setLibrary(Library library) {
		this.library = library;
	}

	@GET
	@Path("books")
	@Produces({MediaType.APPLICATION_JSON})
	public List<Book> listBooks(){
		System.out.println(library);
		return library.getBooks();
	}
	@POST
	@Path("books")
	@Consumes({MediaType.APPLICATION_JSON})
	public Response addBook(Book book, @Context UriInfo uriInfo) {
		library.addBook(book);
		return Response.created(uriInfo.getAbsolutePath()).build();
	}
	@DELETE
	@Path("books/{bookId}")
	public Response deleteBook(@PathParam("bookId") String bookId) {
		library.removeBook(bookId);
		return Response.accepted().build();
	}
	@GET
	@Path("librarians")
	@Produces({MediaType.APPLICATION_JSON})
	public List<User> listLibrarians(){
		return library.getLibrarians();
	}
	@POST
	@Path("librarians")
	@Consumes({MediaType.APPLICATION_JSON})
	public Response addLibrarian(User librarian, @Context UriInfo uriInfo) {
		library.addLibrarian(librarian);
		return Response.created(uriInfo.getAbsolutePath()).build();
	}
	@DELETE
	@Path("librarians/{librariansId}")
	public Response deleteLibrarian(@PathParam("librariansId") String librarianId) {
		library.removeLibrarian(librarianId);
		return Response.accepted().build();
	}
	@GET
	@Path("guests")
	@Produces({MediaType.APPLICATION_JSON})
	public List<User> listGuests(){
		return library.getGuests();
	}
	@POST
	@Path("guests")
	@Consumes({MediaType.APPLICATION_JSON})
	public Response addGuest(User guest, @Context UriInfo uriInfo) {
		library.addGuest(guest);
		return Response.created(uriInfo.getAbsolutePath()).build();
	}
	@DELETE
	@Path("guests/{guestsId}")
	public Response deleteGuest(@PathParam("guestsId") String guestId) {
		library.removeGuest(guestId);
		return Response.accepted().build();
	}
}
