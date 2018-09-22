package de.seite50.rest;

import java.util.Collections;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.apache.meecrowave.jpa.api.Jpa;
import org.apache.meecrowave.jpa.api.Unit;

import de.seite50.models.Book;

@ApplicationScoped
public class BooksService {

	@Inject
	@Unit(name = "seite50")
	EntityManager em;

	public List<Book> getBooks() {
		return em.createQuery("select b from Book b left join fetch b.authors", Book.class).getResultList();
	}

	@Jpa(transactional = true)
	public String addBook(Book book) {
		em.merge(book);
		return book.getId();
	}

	public Book getBook(String id) {
		return em.find(Book.class, id);
	}

	@Jpa(transactional = true)
	public void setBook(Book book) {
		em.merge(book);
	}

	@Jpa(transactional = true)
	public void deleteBook(String id) {
		Book book = em.find(Book.class, id);
		em.remove(book);
	}

	public List<Book> search(String term) {
		if (term == null) {
			return Collections.emptyList();
		}
		TypedQuery<Book> query = em.createQuery(
				"select b from Book b where lower(b.name) like :term or lower(b.isbn) like :term", Book.class);
		query.setParameter("term", "%" + term.toLowerCase() + "%");
		return query.getResultList();
	}
}
