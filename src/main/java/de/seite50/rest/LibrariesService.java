package de.seite50.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import javax.enterprise.context.ApplicationScoped;

import de.seite50.models.Book;
import de.seite50.models.Library;
import de.seite50.models.User;

@ApplicationScoped
public class LibrariesService {
	ConcurrentHashMap<String, Library> libraries = new ConcurrentHashMap<>();
	
	public List<Library> getLibraries(){
		return new ArrayList<>(libraries.values());
	}
	
	public Library getLibrary(String id) {
		return this.libraries.get(id);
	}
	
	public void addLibrary(Library library) {
		UUID id = UUID.randomUUID();
		library.setId(id.toString());
		this.libraries.put(library.getId(), library);
	}
	
	public void setLibrary(Library library) {
		this.libraries.put(library.getId(), library);
	}
	
	public void removeLibrary(String libId) {
		this.libraries.remove(libId);
	}
	
	public List<Book> listBooks(String libId){
		Library lib = getLibrary(libId);
		return lib.getBooks();
	}
	
	public void addBook(String libraryId, Book book) {
		Library lib = getLibrary(libraryId);
		lib.addBook(book);
	}
	
	public void removeBook(String libraryId, String bookId) {
		Library lib = getLibrary(libraryId);
		lib.removeBook(bookId);
	}
	
	public List<User> listLibrarians(String libId){
		Library lib = getLibrary(libId);
		return lib.getLibrarians();
	}
	
	public void addLibrarian(String libraryId, User librarian) {
		Library lib = getLibrary(libraryId);
		lib.addLibrarian(librarian);
	}
	
	public void removeLibrarian(String libraryId, String librarianId) {
		Library lib = getLibrary(libraryId);
		lib.removeLibrarian(librarianId);
	}
	
	public List<User> listGuests(String libId){
		Library lib = getLibrary(libId);
		return lib.getGuests();
	}
	
	public void addGuest(String libraryId, User guest) {
		Library lib = getLibrary(libraryId);
		lib.addGuest(guest);
	}
	
	public void removeGuest(String libraryId, String guestId) {
		Library lib = getLibrary(libraryId);
		lib.removeGuest(guestId);
	}
}
