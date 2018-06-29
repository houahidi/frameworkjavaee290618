package fr.orsys.bibliotheque.spring;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;

import fr.orsys.bibliotheque.modele.Media;

public class SpringTestCase1 {
	Resource resource;
	BeanFactory factory ;

	@Before
	public void setUp() throws Exception {
		 System.out.println("initialisation des ressources");
		 factory = new  ClassPathXmlApplicationContext("modele-beans.xml");
	}

	@After
	public void tearDown() throws Exception {
		 System.out.println("libération des ressources");
		 factory = null;
	}

	@Test
	public void testInjectionParSetter() {
		System.out.println("injection par setter");
		Media media1 = (Media) factory.getBean("media1");
		assertNotNull(media1);
		assertEquals(new Long(1), media1.getIdentifiant());
		assertEquals("Spring pour les experts",media1.getTitre());
	}
	
	
	@Test
	public void testInjectionParConstructeur() {
		
		try {
			System.out.println("initialisation d'une date");
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");
			Date datePublication = dateFormat.parse("26/06/2018");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		
		System.out.println("injection testInjectionParConstructeur");
		Media media2 = (Media) factory.getBean("media2");
		assertNotNull(media2);
		assertEquals(new Long(2) ,media2.getIdentifiant());
		assertEquals("UML",media2.getTitre());
		
		
		
	}

}
