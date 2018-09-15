package de.seite50.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("search")
@ApplicationScoped
public class Search {
	
	@Inject
	private BooksService booksService;
	
	@Inject
	private AuthorsService authorsService;
	
	@GET
	@Path("{searchTerm}")
	public Map<String, List<?>> search(@PathParam("searchTerm") String term) {
		Map<String, List<?>> result = new HashMap<>();
		result.put("books", booksService.search(term));
		result.put("authors", authorsService.search(term));
		return result;
	}
}
