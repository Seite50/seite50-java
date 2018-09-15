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

import de.seite50.models.User;

@Path("users")
@ApplicationScoped
public class Users {
	@Inject
	private UsersService usersService; 
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public List<User> listUsers() {
		return usersService.getUsers();
	}
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addUser(User user, @Context UriInfo uriInfo) {
		String id = usersService.addUser(user);
		return Response.created(uriInfo.getAbsolutePath()).build();
	}
	@DELETE
	@Path("{id}")
	public Response deleteUser(@PathParam("id") String id) {
		boolean deleted = usersService.deleteUser(id);
		
		if (deleted) {
			return Response.accepted().build();
		}
		else {
			return Response.noContent().build();
		}
	}
	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response modifyUser(@PathParam("id") String id, User user) {
		if (usersService.modifyUser(user) == null)
			return Response.notModified().build();
		return Response.accepted().build();
	}
}
