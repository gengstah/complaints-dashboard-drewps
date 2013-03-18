package org.drewps.manager;

import org.drewps.domain.User;

public interface UserManager {
	User getUser(String username);
}