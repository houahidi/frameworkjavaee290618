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
public class JPAExemplaireMediaTestCase {
	
	private static EntityManager entityManager;
	private static Exemplaire exemplaire1;
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
		exemplaire1 = new Exemplaire("ref1", EtatExemplaire.Disponible);
		media1 = new Media(0, "Spring");		
		//entityManager.persist(exemplaire1);
		media1.addExemplaire(exemplaire1);
		entityManager.persist(media1);
		entityManager.getTransaction().commit();
		entityManager.refresh(media1);
		System.out.println("<<<<<<<<<<<Identifiant : "+media1.getIdentifiant());
		
	}
	
	@Test
	public void test2AssocierExemplaireMedia() {
		System.out.println("test2AssocierExemplaireMedia");
		entityManager.getTransaction().begin();
		System.out.println("<<<<<<<<<<<<<<"+media1);		
		media1.addExemplaire(exemplaire1);
		//exemplaire1.setMedia(media1);
		//entityManager.merge(exemplaire1);
		entityManager.getTransaction().commit();
	}
	
	
	@Test
	public void test3SelectExemplaire() {
		System.out.println("test3Select");		
		Exemplaire exemplaire = entityManager.find(Exemplaire.class, exemplaire1.getReference());
		assertNotNull(exemplaire);
		assertEquals(exemplaire, exemplaire1);
		assertEquals(exemplaire.getMedia(), media1);
	}
	
	
	@Test
	public void test3SelectMedia() {
		System.out.println("test3SelectMedia>>>>>>>>>>>>>>>>>>>>>>>>>");
		entityManager = factory.createEntityManager();
		Media media = entityManager.find(Media.class, media1.getIdentifiant());
		assertNotNull(media);
		assertEquals(media, media1);
		System.out.println("test3SelectMedia>>>>>>>>>>>>>>>>>>>>>>>>>liste exemplaire");		
		assertNotNull(media.getExemplaires());
		assertEquals(media.getExemplaires().size(), 1);
	}
	

}
