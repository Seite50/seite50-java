package de.seite50.rest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import javax.enterprise.context.ApplicationScoped;

import de.seite50.models.Book;
import de.seite50.models.Library;
import de.seite50.models.User;

@ApplicationScoped
public class LibrariesService {
	ConcurrentHashMap<String, LibraryResource> libraries = new ConcurrentHashMap<>();
	
	public List<String> getLibraries(){
		return Collections.list(libraries.keys());
	}
	
	public LibraryResource getLibrary(String id) {
		return this.libraries.get(id);
	}

	
	public void addLibrary(Library library) {
		UUID id = UUID.randomUUID();
		library.setId(id.toString());
		this.libraries.put(library.getId(), new LibraryResource(library));
	}
	
	public void setLibrary(Library library) {
		LibraryResource libResource = this.libraries.get(library.getId());
		libResource.setLibrary(library);
		this.libraries.put(library.getId(), libResource);
	}
	
	public void removeLibrary(String libId) {
		this.libraries.remove(libId);
	}
}
