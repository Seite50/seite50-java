package de.seite50.rest;

import java.util.List;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.apache.meecrowave.jpa.api.Jpa;
import org.apache.meecrowave.jpa.api.Unit;

import de.seite50.models.Book;
import de.seite50.models.Library;
import de.seite50.models.User;

@Dependent
public class LibraryService {

	private Library library;

	@Inject
	@Unit(name = "seite50")
	EntityManager em;

	public void setLibrary(Library library) {
		this.library = library;
	}

	public Library getLibrary() {
		TypedQuery<Library> query = em.createQuery(
				"select l from Library l left join fetch l.guests left join fetch l.librarians left join fetch l.books where l.id = :id",
				Library.class);
		query.setParameter("id", library.getId());
		return query.getSingleResult();
	}

	@Jpa(transactional = true)
	public void removeBook(String id) {
		Book book = em.find(Book.class, id);
		library.removeBook(book);
	}

	@Jpa(transactional = true)
	public void addBook(Book book) {
		library.addBook(book);
	}

	public List<User> getLibrarians() {
		System.out.println("Nutze lib " + library.getId());
		TypedQuery<Library> query = em
				.createQuery("select l from Library l left join fetch l.librarians where l = :library", Library.class);
		query.setParameter("library", library);
		Library l = query.getSingleResult();
		return l.getLibrarians();
	}

	@Jpa(transactional = true)
	public void addLibrarian(User librarian) {
		library.addLibrarian(librarian);
	}

	@Jpa(transactional = true)
	public void removeLibrarian(String librarianId) {
		library.removeLibrarian(em.find(User.class, librarianId));
	}

	public List<User> getGuests() {
		TypedQuery<Library> query = em
				.createQuery("select l from Library l left join fetch l.guests where l = :library", Library.class);
		query.setParameter("library", library);
		Library l = query.getSingleResult();
		return l.getGuests();
	}

	@Jpa(transactional = true)
	public void addGuest(User guest) {
		library.addGuest(guest);
	}

	@Jpa(transactional = true)
	public void removeGuest(String guestId) {
		library.removeGuest(em.find(User.class, guestId));
	}
}
