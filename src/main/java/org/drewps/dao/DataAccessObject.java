package org.drewps.dao;

import java.util.List;

public interface DataAccessObject {
	Object add(Object o);
	Object update(Object o);
	void remove(Object o);
	<T> List<T> listOpenComplaints(Class<T> clazz);
	<T> List<T> listClosedComplaints(Class<T> clazz);
	<T> T get(Long id, Class<T> clazz);
	<T> T get(String id, Class<T> clazz);
}