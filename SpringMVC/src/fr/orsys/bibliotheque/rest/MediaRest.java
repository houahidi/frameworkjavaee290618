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
@RequestMapping("/mediasrs")
public class MediaRest {

	@Autowired
	private Media media1;
	
	
	@Autowired
	private EntiteDao<Media, Long> mediaDao;
	
	public MediaRest() {
		System.out.println("HelloRest - Instanciation");
	}	
	


	
	
	@GetMapping(value="/media", produces= {MediaType.APPLICATION_JSON_VALUE})
	public Media displayMedia() {
		return media1;
	}
	
	
	
	@GetMapping(produces= {MediaType.APPLICATION_JSON_VALUE})
	public List<Media> displayMedias() {
		System.out.println("display medias with daos");
		List<Media> medias = null;
		try {
			medias =  mediaDao.findAll(Media.class,0,10);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return medias;
	}
	
	
}
