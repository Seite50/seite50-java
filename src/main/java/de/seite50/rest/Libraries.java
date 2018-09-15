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
	public List<String> listLibraries() {
		return libService.getLibraries();
	}

	@Path("{id}")
	public LibraryResource getLibrary(@PathParam("id") String id) {
		return libService.getLibrary(id);
	}
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addLibrary(Library lib, @Context UriInfo uriInfo) {
		libService.addLibrary(lib);
		return Response.created(uriInfo.getAbsolutePath()).build();
	}
//	@DELETE
//	@Path("{id}")
//	public Response deleteLibrary(@PathParam("id") String id) {
//		libService.removeLibrary(id);
//		return Response.accepted().build();
//	}
//	@PUT
//	@Path("{id}")
//	@Consumes(MediaType.APPLICATION_JSON)
//	public Response modifyLibrary(@PathParam("id") String id, Library lib) {
//		libService.setLibrary(lib);
//		return Response.accepted().build();
//	}
}
