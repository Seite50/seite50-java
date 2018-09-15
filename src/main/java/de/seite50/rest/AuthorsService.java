package de.seite50.rest;

import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import org.apache.meecrowave.jpa.api.Jpa;
import org.apache.meecrowave.jpa.api.Unit;

import de.seite50.models.Author;

@ApplicationScoped
public class AuthorsService {

	@Inject
	@Unit(name = "seite50")
	EntityManager em;

	ConcurrentHashMap<String, Author> authors = new ConcurrentHashMap<>();

	@Jpa(transactional = false)
	public List<Author> getAuthors() {
		return em.createQuery("select author from Author author", Author.class).getResultList();
	}

	@Jpa(transactional = true)
	public String addAuthor(Author author) {
		String id = UUID.randomUUID().toString();
		author.setId(id);
		em.merge(author);
		return id;
	}

	@Jpa(transactional = false)
	public Author getAuthor(String authorId) {
		return em.find(Author.class, authorId);
	}

	@Jpa(transactional = true)
	public void changeAuthor(Author author) {
		em.merge(author);
	}

	@Jpa(transactional = true)
	public void deleteAuthor(String id) {
		Author author = em.find(Author.class, id);
		em.remove(author);
	}

	@Jpa(transactional = false)
	public List<Author> search(String term) {
		if (term == null) {
			return Collections.emptyList();
		}
		TypedQuery<Author> query = em.createQuery(
				"select a from Author a where lower(a.givenname) like :term or lower(a.surname) = like(:term)",
				Author.class);
		query.setParameter("term", term.toLowerCase());
		return query.getResultList();
	}

}
