package de.seite50.rest;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.apache.meecrowave.jpa.api.Jpa;
import org.apache.meecrowave.jpa.api.Unit;

import de.seite50.models.Library;

@RequestScoped
public class LibrariesService {

	@Inject
	@Unit(name = "seite50")
	EntityManager em;

	@Inject
	LibraryResource libResource;

	public List<String> getLibraries() {
		return em.createQuery("select l.id from Library l", String.class).getResultList();
	}

	public LibraryResource getLibrary(String id) {
		Library library = em.find(Library.class, id);
		libResource.setLibrary(library);
		return libResource;
	}

	@Jpa(transactional = true)
	public void addLibrary(Library library) {
		em.merge(library);
	}

	@Jpa(transactional = true)
	public void setLibrary(Library library) {
		em.merge(library);
	}

	@Jpa(transactional = true)
	public void removeLibrary(String libId) {
		em.remove(em.find(Library.class, libId));
	}
}
