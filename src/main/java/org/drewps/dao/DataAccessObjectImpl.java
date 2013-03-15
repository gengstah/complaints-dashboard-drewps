package org.drewps.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class DataAccessObjectImpl implements DataAccessObject {
	@PersistenceContext
	private EntityManager em;

	public Object add(Object o) {
		em.persist(o);
		return o;
	}

	public Object update(Object o) {
		return em.merge(o);
	}

	public void delete(Object o) {
		em.remove(o);
	}

	public <T> List<T> getEntities(Class<T> clazz) {
		return em.createQuery("SELECT c FROM " + clazz.getName() + " c", clazz).getResultList();
	}
}