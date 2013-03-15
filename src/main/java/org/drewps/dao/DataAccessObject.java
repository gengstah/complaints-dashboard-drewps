package org.drewps.dao;

import java.util.List;

public interface DataAccessObject {
	Object add(Object o);
	Object update(Object o);
	void delete(Object o);
	<T> List<T> getEntities(Class<T> clazz);
}