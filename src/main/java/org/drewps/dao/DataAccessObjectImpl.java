package org.drewps.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.drewps.domain.FinalStatus;

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

	public void remove(Object o) {
		em.remove(o);
	}

	@Override
	public <T> List<T> listOpenComplaints(Class<T> clazz) {
		String query = "SELECT c FROM " + clazz.getName() + 
				" c WHERE c.finalStatus = :finalStatus" +
				" ORDER BY c.date DESC";
		return em.createQuery(query, clazz)
				.setParameter("finalStatus", FinalStatus.OPEN)
				.getResultList();
	}

	@Override
	public <T> List<T> listClosedComplaints(Class<T> clazz) {
		String query = "SELECT c FROM " + clazz.getName() + 
				" c WHERE c.finalStatus = :finalStatus" +
				" ORDER BY c.date DESC";
		return em.createQuery(query, clazz)
				.setParameter("finalStatus", FinalStatus.CLOSED)
				.getResultList();
	}
	
	@Override
	public <T> List<T> listUsers(Class<T> clazz) {
		String query = "SELECT c FROM " + clazz.getName() + " c";
		return em.createQuery(query, clazz).getResultList();
	}

	@Override
	public <T> T get(Long id, Class<T> clazz) {
		return em.find(clazz, id);
	}

	@Override
	public <T> T get(String id, Class<T> clazz) {
		return em.find(clazz, id);
	}
}