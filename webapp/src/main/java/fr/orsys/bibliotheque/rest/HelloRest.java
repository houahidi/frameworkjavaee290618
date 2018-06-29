package fr.orsys.bibliotheque.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/hellors")
public class HelloRest {

		
	public HelloRest() {
		System.out.println("HelloRest - Instanciation");
	}	
	
	
	@Path("text")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayHello() {
		return "Bonjour tout le monde";
	}
	
	
	@GET
	@Produces(MediaType.TEXT_HTML)	
	public String sayHelloHTML() {
		return "<html><body><h1>Bonjour tout le monde</h1></body></html>";
	}
	
	
}
