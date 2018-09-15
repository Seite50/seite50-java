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
import de.seite50.models.Author;

@Path("authors")
@ApplicationScoped
public class Authors {

	@Inject
	private Defaults defaults;
	
	@Inject
	private AuthorsService service;
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public List<Author> listAuthors() {
		return service.getAuthors();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addAuthor(Author author, @Context UriInfo location) {
		service.addAuthor(author);
		return Response.created(location.getAbsolutePath()).build();
	}
}
