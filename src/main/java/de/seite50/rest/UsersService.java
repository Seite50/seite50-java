package de.seite50.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import javax.enterprise.context.ApplicationScoped;

import de.seite50.models.User;

@ApplicationScoped
public class UsersService {
	ConcurrentHashMap<String, User> users = new ConcurrentHashMap<>();
	
	public List<User> getUsers() {
		return new ArrayList<>(users.values());
	}
	
	public String addUser(User user) {
		users.put(user.getId(), user);
		return user.getId();
	}
	
	public boolean deleteUser(String id) {
		if (users.containsKey(id)) {
			users.remove(id);
			return true;
		}

		return false;
	}
	
	public String modifyUser(User user) {
		if (users.containsKey(user.getId())){
			users.put(user.getId(), user);
			return user.getId();
		}
		
		return null;
	}
}
