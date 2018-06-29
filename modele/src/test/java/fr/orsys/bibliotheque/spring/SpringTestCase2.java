package fr.orsys.bibliotheque.spring;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.orsys.bibliotheque.modele.Media;



@ContextConfiguration(locations= {"classpath:modele-beans.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class SpringTestCase2 {
	
	@javax.annotation.Resource(name="media1")
	private Media media1;
	@Autowired
	private Media media2;
	@Autowired
	private Media media3;
	

	@Test
	public void testInjectionParSetter() {
		System.out.println("injection par setter");
		assertNotNull(media1);
		assertEquals(new Long(1), media1.getIdentifiant());
		assertEquals("Spring pour les experts",media1.getTitre());
	}
	
	
	@Test
	public void testInjectionParConstructeur() {
		Date datePublication = null;
		try {
			System.out.println("initialisation d'une date");
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			datePublication = dateFormat.parse("26/06/2018");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		
		System.out.println("injection testInjectionParConstructeur");
		assertNotNull(media2);
		assertEquals(new Long(2), media2.getIdentifiant());
		assertEquals("UML",media2.getTitre());
		assertEquals(datePublication, media2.getDatePublication());		
		
		
	}
	
	@Test
	public void testList() {
		System.out.println("testList");
		assertNotNull(media3);
		assertNotNull(media3.getExemplaires());
		assertEquals(2, media3.getExemplaires().size());
	}
		
}