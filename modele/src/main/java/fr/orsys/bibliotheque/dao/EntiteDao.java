package fr.orsys.bibliotheque.dao;

import java.util.List;

public interface EntiteDao<Entite, TID> {	
	void create(Entite e) throws DaoException;
	void update(Entite e) throws DaoException;
	void remove(Class<Entite> type,TID id) throws DaoException;
	Entite findById(Class<Entite> type, TID id) throws DaoException;
	List<Entite> findAll(Class<Entite> type, int debut, int nombre) throws DaoException;
	
}
