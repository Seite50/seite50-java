package de.seite50.rest;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
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

@Path("libraries")
@ApplicationScoped
public class Libraries {
	@Inject
	LibrariesService libService;
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public List<Library> listLibraries() {
		return libService.getLibraries();
	}
	@GET
	@Path("{id}")
	@Produces({MediaType.APPLICATION_JSON})
	public Library getLibrary(@PathParam("id") String id) {
		return libService.getLibrary(id);
	}
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addLibrary(Library lib, @Context UriInfo uriInfo) {
		libService.addLibrary(lib);
		return Response.created(uriInfo.getAbsolutePath()).build();
	}
	@DELETE
	@Path("{id}")
	public Response deleteLibrary(@PathParam("id") String id) {
		libService.removeLibrary(id);
		return Response.accepted().build();
	}
	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response modifyLibrary(@PathParam("id") String id, Library lib) {
		libService.setLibrary(lib);
		return Response.accepted().build();
	}
	@GET
	@Path("{id}/books")
	@Produces({MediaType.APPLICATION_JSON})
	public List<Book> listBooks(@PathParam("id") String libId){
		return libService.listBooks(libId);
	}
	@POST
	@Path("{id}/books")
	@Consumes({MediaType.APPLICATION_JSON})
	public Response addBook(@PathParam("id") String libId, Book book, @Context UriInfo uriInfo) {
		libService.addBook(libId, book);
		return Response.created(uriInfo.getAbsolutePath()).build();
	}
	@DELETE
	@Path("{id}/books{bookId}")
	public Response deleteBook(@PathParam("id") String libId, @PathParam("bookId") String bookId) {
		libService.removeBook(libId, bookId);
		return Response.accepted().build();
	}
	@GET
	@Path("{id}/librarians")
	@Produces({MediaType.APPLICATION_JSON})
	public List<User> listLibrarians(@PathParam("id") String libId){
		return libService.listLibrarians(libId);
	}
	@POST
	@Path("{id}/librarians")
	@Consumes({MediaType.APPLICATION_JSON})
	public Response addLibrarian(@PathParam("id") String libId, User librarian, @Context UriInfo uriInfo) {
		libService.addLibrarian(libId, librarian);
		return Response.created(uriInfo.getAbsolutePath()).build();
	}
	@DELETE
	@Path("{id}/librarians{librariansId}")
	public Response deleteLibrarian(@PathParam("id") String libId, @PathParam("librariansId") String librarianId) {
		libService.removeLibrarian(libId, librarianId);
		return Response.accepted().build();
	}
	@GET
	@Path("{id}/guests")
	@Produces({MediaType.APPLICATION_JSON})
	public List<User> listGuests(@PathParam("id") String libId){
		return libService.listGuests(libId);
	}
	@POST
	@Path("{id}/guests")
	@Consumes({MediaType.APPLICATION_JSON})
	public Response addGuest(@PathParam("id") String libId, User guest, @Context UriInfo uriInfo) {
		libService.addGuest(libId, guest);
		return Response.created(uriInfo.getAbsolutePath()).build();
	}
	@DELETE
	@Path("{id}/guests{guestsId}")
	public Response deleteGuest(@PathParam("id") String libId, @PathParam("guestsId") String guestId) {
		libService.removeGuest(libId, guestId);
		return Response.accepted().build();
	}
}
