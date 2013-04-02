package org.drewps.manager;

import java.util.List;

import org.drewps.domain.Role;
import org.drewps.domain.User;

public interface UserManager {
	User findUser(String username);
	User addUser(User user);
	User updateUser(User user);
	void removeUser(User user);
	List<User> getUsers();
	List<Role> getRoles();
}