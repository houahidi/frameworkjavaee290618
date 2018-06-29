package fr.orsys.bibliotheque.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.orsys.bibliotheque.dao.EntiteDao;
import fr.orsys.bibliotheque.modele.Media;

public class SpringUtil {
	
	
	private static ApplicationContext context;
	
	
	public static   EntiteDao<Media, Long> getMediaDao(){
		
		if(context == null) {
			context = new ClassPathXmlApplicationContext("classpath:modele-beans.xml");
			
		}		
		
		return (EntiteDao<Media, Long>) context.getBean("mediaDao");
	}

}
