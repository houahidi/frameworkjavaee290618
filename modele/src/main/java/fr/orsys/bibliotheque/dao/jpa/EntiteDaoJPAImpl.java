package fr.orsys.bibliotheque.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import fr.orsys.bibliotheque.dao.DaoException;
import fr.orsys.bibliotheque.dao.EntiteDao;

public class EntiteDaoJPAImpl<Entite, TID> implements EntiteDao<Entite, TID> {

	private EntityManager entityManager;
	
	public EntiteDaoJPAImpl() {
	}
	
	public EntiteDaoJPAImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public void create(Entite e) throws DaoException {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(e);
			entityManager.getTransaction().commit();
		}catch (Exception ex) {
			throw new DaoException(ex.getMessage());
		}
		
	}

	@Override
	public void update(Entite e) throws DaoException {
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(e);
			entityManager.getTransaction().commit();
		}catch (Exception ex) {
			throw new DaoException(ex.getMessage());
		}
		
	}

	@Override
	public void remove(Class<Entite> type,TID id) throws DaoException {
		try {
			entityManager.getTransaction().begin();
			Entite entite = findById(type, id);
			entityManager.remove(entite);
			entityManager.getTransaction().commit();
		}catch (Exception ex) {
			throw new DaoException(ex.getMessage());
		}
		
	}

	@Override
	public Entite findById(Class<Entite> type, TID id) throws DaoException {	
		return (Entite) entityManager.find(type, id);
	}
	
	public List<Entite> findAll(Class<Entite> type, int debut, int nombre) throws DaoException{
		
		Query query= entityManager.createQuery("select e from "+ type.getName() +" e ");
		query.setFirstResult(debut);
		query.setMaxResults(nombre);
		return query.getResultList();
	}

}
