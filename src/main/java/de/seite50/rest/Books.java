package de.seite50.rest;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import de.seite50.configuration.Defaults;

@Path("books")
@ApplicationScoped
public class Books {
	
	@Inject
	private Defaults defaults;

	@GET
	public String info() {
		return defaults.getName();
	}
	
}
