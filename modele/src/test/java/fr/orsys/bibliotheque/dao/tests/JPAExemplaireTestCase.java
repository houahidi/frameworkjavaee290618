package fr.orsys.bibliotheque.dao.tests;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import fr.orsys.bibliotheque.modele.EtatExemplaire;
import fr.orsys.bibliotheque.modele.Exemplaire;
import fr.orsys.bibliotheque.modele.Media;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JPAExemplaireTestCase {
	
	private static EntityManager entityManager;
	private static Exemplaire exemplaire1;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("initialisation de l'entity manager");
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("bibliotheque-model-pu");
		entityManager = factory.createEntityManager();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("liberation de l'entity manager");
		entityManager.close();
	}

	@Test
	public void test1Create() {
		System.out.println("test1Create");
		entityManager.getTransaction().begin();
		// si GeneratedValue est utilisé il faudra specifier la valeur par defaut à l'id
		exemplaire1 = new Exemplaire("ref1", EtatExemplaire.Disponible);
		entityManager.persist(exemplaire1);
		entityManager.getTransaction().commit();
	}
	
	
	@Test
	public void test2Update() {
		System.out.println("test2Update");
		entityManager.getTransaction().begin();
		exemplaire1.setEtat(EtatExemplaire.Reserve);;
		entityManager.merge(exemplaire1);
		entityManager.getTransaction().commit();
	}
	
	
	@Test
	public void test3Select() {
		System.out.println("test3Select");		
		Exemplaire exemplaire = entityManager.find(Exemplaire.class, exemplaire1.getReference());
		assertEquals(exemplaire, exemplaire1);
	}
	
	
	@Test
	public void test3SelectAll() {
		System.out.println("test3SelectAll");		
		List<Exemplaire> exemplaires = entityManager.createQuery("select e from Exemplaire e").getResultList();
		assertNotNull(exemplaires);
		assertEquals(exemplaires.size(), 1);
	}

	@Test
	public void test4Remove() {
		System.out.println("test3Remove");
		entityManager.getTransaction().begin();
		entityManager.remove(exemplaire1);
		entityManager.getTransaction().commit();
	}
	
	
	
	
	

}
