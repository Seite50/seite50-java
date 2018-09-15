package de.seite50.rest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;

import de.seite50.models.Author;

@ApplicationScoped
public class AuthorsService {

	ConcurrentHashMap<String, Author> authors = new ConcurrentHashMap<>();

	public List<Author> getAuthors() {
		return new ArrayList<>(authors.values());
	}

	public String addAuthor(Author author) {
		String id = UUID.randomUUID().toString();
		author.setId(id);
		authors.put(id, author);
		return id;
	}

	public Author getAuthor(String authorId) {
		return authors.get(authorId);
	}

	public void changeAuthor(Author author) {
		authors.put(author.getId(), author);
	}

	public void deleteAuthor(String id) {
		authors.remove(id);
	}

	public List<Object> search(String term) {
		if (term == null) {
			return Collections.emptyList();
		}
		String lcTerm = term.toLowerCase();
		return authors.values().stream()
				.filter(a -> (a.getGivenname() != null && a.getGivenname().toLowerCase().indexOf(lcTerm) >= 0)
						|| (a.getSurname() != null && a.getSurname().toLowerCase().indexOf(lcTerm) >= 0))
				.collect(Collectors.toList());
	}

}
