package fr.orsys.bibliotheque.dao;

public class DaoException  extends Exception{

	public DaoException() {
		super("Erreur : problème d'acces aux donnees");		
	}

	public DaoException(String message) {
		super(message);
	}
	
	
}
