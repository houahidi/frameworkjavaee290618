package fr.orsys.bibliotheque.rest;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.orsys.bibliotheque.dao.DaoException;
import fr.orsys.bibliotheque.dao.EntiteDao;
import fr.orsys.bibliotheque.modele.Categorie;
import fr.orsys.bibliotheque.modele.Media;


@RestController
@RequestMapping("/hellors")
public class HelloRest {

	
	public HelloRest() {
		System.out.println("HelloRest - Instanciation");
	}	
	

	
	@GetMapping(produces= {MediaType.TEXT_HTML_VALUE})
	public String sayHelloHTML() {
		return "<html><body><h1>Bonjour tout le monde</h1></body></html>";
	}
	
	
	
	
}
