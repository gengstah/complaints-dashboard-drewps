package org.drewps.manager;

import java.util.List;

import org.drewps.dao.DataAccessObject;
import org.drewps.domain.Role;
import org.drewps.domain.User;

public class UserManagerImpl implements UserManager {
	private DataAccessObject dao;
	
	public void setDao(DataAccessObject dao) {
		this.dao = dao;
	}

	@Override
	public User findUser(String username) {
		return dao.get(username, User.class);
	}

	@Override
	public User addUser(User user) {
		return (User) dao.add(user);
	}

	@Override
	public User updateUser(User user) {
		return (User) dao.update(user);
	}

	@Override
	public void removeUser(User user) {
		user = findUser(user.getUsername());
		user.setRoles(null);
		
		dao.remove(user);
	}

	@Override
	public List<User> getUsers() {
		return dao.listUsers(User.class);
	}

	@Override
	public List<Role> getRoles() {
		return dao.listUsers(Role.class);
	}
}