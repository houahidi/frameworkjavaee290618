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

import fr.orsys.bibliotheque.dao.EntiteDao;
import fr.orsys.bibliotheque.dao.jpa.EntiteDaoJPAImpl;
import fr.orsys.bibliotheque.modele.Categorie;
import fr.orsys.bibliotheque.modele.Media;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JPAEntiteCategorieDaoTestCase {
	
	private static EntityManager entityManager;
	private static Categorie categorie1;
	private static EntiteDao<Categorie, Long> categorieDao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("initialisation de l'entity manager");
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("bibliotheque-model-pu");
		entityManager = factory.createEntityManager();
		categorieDao = new EntiteDaoJPAImpl<>(entityManager);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("liberation de l'entity manager");
		entityManager.close();
	}

	@Test
	public void test1Create() {
		System.out.println("test1Create");
		try {
			categorie1 = new Categorie(0,"Spring pour les experts");
			categorieDao.create(categorie1);
		}catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	
	@Test
	public void test2Update() {
		System.out.println("test2Update");
		try {
			categorie1.setLabelle("Info");
			categorieDao.update(categorie1);		
		}catch (Exception e) {
			fail(e.getMessage());
		}
		
	}
	
	
	@Test
	public void test3Select() {
		System.out.println("test3Select");	
		try {
			Categorie categorie = categorieDao.findById(Categorie.class, 1L);
			assertEquals(categorie, categorie1);
		}catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	
	@Test
	public void test3SelectAll() {
		System.out.println("test3SelectAll");		
		try {
			List<Categorie> cats = categorieDao.findAll(Categorie.class, 0, 10);
			assertNotNull(cats);
			assertEquals(cats.size(), 1);
		}catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void test4Remove() {
		System.out.println("test3Remove");
		try {
			categorieDao.remove(Categorie.class, 1L);
		}catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	
	
	
	

}
