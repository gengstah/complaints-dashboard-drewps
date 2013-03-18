package org.drewps.manager;

import org.drewps.dao.DataAccessObject;
import org.drewps.domain.User;

public class UserManagerImpl implements UserManager {
	private DataAccessObject dao;
	
	@Override
	public User getUser(String username) {
		return dao.get(username, User.class);
	}
	
	public void setDao(DataAccessObject dao) {
		this.dao = dao;
	}
}