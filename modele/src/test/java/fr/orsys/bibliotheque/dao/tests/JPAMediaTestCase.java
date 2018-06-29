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

import fr.orsys.bibliotheque.modele.Media;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JPAMediaTestCase {
	
	private static EntityManager entityManager;
	private static Media media1;
	
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
		media1 = new Media(0,"Spring pour les experts");
		entityManager.persist(media1);
		entityManager.getTransaction().commit();
	}
	
	
	@Test
	public void test2Update() {
		System.out.println("test2Update");
		entityManager.getTransaction().begin();
		media1.setTitre("UML");
		entityManager.merge(media1);
		entityManager.getTransaction().commit();
	}
	
	
	@Test
	public void test3Select() {
		System.out.println("test3Select");		
		Media media = entityManager.find(Media.class, media1.getIdentifiant());
		assertEquals(media, media1);
	}
	
	
	@Test
	public void test3SelectAll() {
		System.out.println("test3SelectAll");		
		List<Media> medias = entityManager.createQuery("select m from Media m").getResultList();
		assertNotNull(medias);
		assertEquals(medias.size(), 1);
	}

	@Test
	public void test4Remove() {
		System.out.println("test3Remove");
		entityManager.getTransaction().begin();
		entityManager.remove(media1);
		entityManager.getTransaction().commit();
	}
	
	
	
	
	

}
