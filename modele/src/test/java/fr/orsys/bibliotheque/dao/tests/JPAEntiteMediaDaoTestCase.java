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
import fr.orsys.bibliotheque.modele.Media;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JPAEntiteMediaDaoTestCase {
	
	private static EntityManager entityManager;
	private static Media media1;
	private static EntiteDao<Media, Long> mediaDao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("initialisation de l'entity manager");
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("bibliotheque-model-pu");
		entityManager = factory.createEntityManager();
		mediaDao = new EntiteDaoJPAImpl<>(entityManager);
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
			media1 = new Media(0,"Spring pour les experts");
			mediaDao.create(media1);
			
		}catch (Exception e) {
			fail(e.getMessage());
		}
		
	}
	
	
	@Test
	public void test2Update() {
		System.out.println("test2Update");
		try {
			media1.setTitre("UML");
			mediaDao.update(media1);		
		}catch (Exception e) {
			fail(e.getMessage());
		}
		
	}
	
	
	@Test
	public void test3Select() {
		System.out.println("test3Select");	
		try {
			Media media = mediaDao.findById(Media.class, 1L);
			assertEquals(media, media1);
		}catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	
	@Test
	public void test3SelectAll() 
	{
		System.out.println("test3SelectAll");		
		try {
			List<Media> medias = mediaDao.findAll(Media.class, 0, 10);
			assertNotNull(medias);
			assertEquals(medias.size(), 1);
		}catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void test4Remove() {
		System.out.println("test3Remove");
		try {
			mediaDao.remove(Media.class, 1L);
		}catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	
	
	
	

}
