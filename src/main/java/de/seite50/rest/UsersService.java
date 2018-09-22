package de.seite50.rest;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.apache.meecrowave.jpa.api.Jpa;
import org.apache.meecrowave.jpa.api.Unit;

import de.seite50.models.User;

@ApplicationScoped
public class UsersService {

	@Inject
	@Unit(name = "seite50")
	EntityManager em;

	public List<User> getUsers() {
		return em.createQuery("select u from User u", User.class).getResultList();
	}

	@Jpa(transactional = true)
	public String addUser(User user) {
		em.merge(user);
		return user.getId();
	}

	@Jpa(transactional = true)
	public boolean deleteUser(String id) {
		User user = em.find(User.class, id);
		em.remove(user);
		return true;
	}

	public User getUser(String id) {
		return em.find(User.class, id);
	}

}
