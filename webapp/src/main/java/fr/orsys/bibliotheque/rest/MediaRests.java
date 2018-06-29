package fr.orsys.bibliotheque.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.orsys.bibliotheque.dao.DaoException;
import fr.orsys.bibliotheque.dao.EntiteDao;
import fr.orsys.bibliotheque.modele.Entite;
import fr.orsys.bibliotheque.modele.Media;
import fr.orsys.bibliotheque.util.SpringUtil;

@Path("/mediasrs")
public class MediaRests {
	
	public MediaRests() {
	}
	
	
	@GET	
	@Produces(MediaType.APPLICATION_JSON)
	public List<Media> listerMedias() {
		System.out.println("listerMedias");
		EntiteDao<Media, Long>  mediaDao = SpringUtil.getMediaDao();
		List<Media> medias = null;
		try {
			medias = mediaDao.findAll(Media.class, 0, 10);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Nombre medias : "+ medias.size());
		return medias;
	}
	
	
	@Path("/debut/{debut}/nombre/{nombre}")
	@Produces(MediaType.APPLICATION_JSON)
	@GET	
	public List<Media> listerMedias(@PathParam("debut") int debut, @PathParam("nombre") int size) {
		System.out.println("listerMedias");
		EntiteDao<Media, Long>  mediaDao = SpringUtil.getMediaDao();
		List<Media> medias = null;
		try {
			medias = mediaDao.findAll(Media.class, debut, size);
		} catch (DaoException e) {
			e.printStackTrace();
		}
		System.out.println("Nombre medias : "+ medias.size());
		return medias;
	}
	
	
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@POST	
	public List<Media> ajouterMedia(Media media) {
		System.out.println("ajouter");
		EntiteDao<Media, Long>  mediaDao = SpringUtil.getMediaDao();
		List<Media> medias = null;
		try {
			mediaDao.create(media);
			medias = mediaDao.findAll(Media.class, 0, 10);
		} catch (DaoException e) {
			e.printStackTrace();
		}
		System.out.println("Nombre medias : "+ medias.size());
		return medias;
	}
	
	

	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@PUT	
	public List<Media> updateMedia(Media media) {
		System.out.println("updateMedia");
		EntiteDao<Media, Long>  mediaDao = SpringUtil.getMediaDao();
		List<Media> medias = null;
		try {
			mediaDao.update(media);
			medias = mediaDao.findAll(Media.class, 0, 10);
		} catch (DaoException e) {
			e.printStackTrace();
		}
		System.out.println("Nombre medias : "+ medias.size());
		return medias;
	}
	
	
	

}
