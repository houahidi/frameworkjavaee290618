package fr.orsys.bibliotheque.dao.tests;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.orsys.bibliotheque.modele.Media;

public class JPATest {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("bibliotheque-model-pu");
		EntityManager entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();
		Media media1 = new Media(0, "UML");
		
		entityManager.persist(media1);
		
		
		entityManager.getTransaction().commit();
		entityManager.close();
		factory.close();

	}

}
