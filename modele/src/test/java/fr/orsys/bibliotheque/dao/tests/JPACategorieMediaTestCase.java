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

import fr.orsys.bibliotheque.modele.Categorie;
import fr.orsys.bibliotheque.modele.EtatExemplaire;
import fr.orsys.bibliotheque.modele.Exemplaire;
import fr.orsys.bibliotheque.modele.Media;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JPACategorieMediaTestCase {
	
	private static EntityManager entityManager;
	private static Categorie categorie1;
	private static EntityManagerFactory factory;
	private static Media media1;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("initialisation de l'entity manager");
		factory = Persistence.createEntityManagerFactory("bibliotheque-model-pu");
		entityManager = factory.createEntityManager();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("liberation de l'entity manager");
		entityManager.close();
		factory.close();
	}

	@Test
	public void test1Create() {
		System.out.println("test1Create");
		entityManager.getTransaction().begin();
		// si GeneratedValue est utilisé il faudra specifier la valeur par defaut à l'id
		categorie1 = new Categorie(0, "Sciences");
		media1 = new Media(0, "Spring");		
		entityManager.persist(categorie1);
		entityManager.persist(media1);
		entityManager.getTransaction().commit();
	}
	
	@Test
	public void test2AssocierCategorieMedia() {
		System.out.println("test2AssocierCategorieMedia");
		entityManager.getTransaction().begin();
		media1.addCategorie(categorie1);
		//entityManager.merge(media1);
		entityManager.getTransaction().commit();
	}
	
	
	@Test
	public void test3SelectMediaCategorie() {
		System.out.println("test3SelectCategorie");		
		Media media = entityManager.find(Media.class, media1.getIdentifiant());
		assertNotNull(media);
		assertEquals(media1, media);
		assertNotNull(media.getCategories());
		assertEquals(media.getCategories().size(), 1);
	}
	

	

}
