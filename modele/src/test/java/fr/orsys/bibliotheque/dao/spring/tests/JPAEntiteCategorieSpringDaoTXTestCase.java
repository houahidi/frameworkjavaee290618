package fr.orsys.bibliotheque.dao.spring.tests;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.orsys.bibliotheque.dao.EntiteDao;
import fr.orsys.bibliotheque.dao.jpa.EntiteDaoJPAImpl;
import fr.orsys.bibliotheque.modele.Categorie;
import fr.orsys.bibliotheque.modele.Media;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@ContextConfiguration(locations= {"classpath:modele-beans-tx.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class JPAEntiteCategorieSpringDaoTXTestCase {
	
	@Autowired
	private  Categorie categorie1;
	@Resource(name="eniteDaoTx")
	private  EntiteDao<Categorie, Long> categorieDao;
	
	
	@Test
	public void test1Create() {
		System.out.println("test1Create");
		try {			
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
