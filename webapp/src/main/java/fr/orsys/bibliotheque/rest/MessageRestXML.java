package fr.orsys.bibliotheque.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBElement;


@Path("/messages/xml")
public class MessageRestXML {

	private static List<Message> messages;
	
	
	static {
		
		messages = new ArrayList<>();
		messages.add(new Message(0, "message1"));
		messages.add(new Message(1, "message2"));
		
		
	}
		
	public MessageRestXML() {
		System.out.println("MessageRest - Instanciation");
		
	}	
	
	
	@GET
	@Produces(MediaType.TEXT_XML)
	public List<Message> listerMessages() {
		return messages;
	}
	
	@GET
	@Path("/id/{id}")
	@Produces(MediaType.TEXT_XML)
	public Message listeMessage(@PathParam("id") int id) {
		return messages.get(id);
	}
	
	

	@DELETE
	@Path("/id/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteMessage(@PathParam("id") int id) {
		Message m = messages.get(id);
		if(m != null ) {
			messages.remove(id);
			return "OK";
		}else {
			return "K0";
		}
	}
	
	@POST	
	@Produces(MediaType.TEXT_XML)
	@Consumes(MediaType.TEXT_XML)
	public List<Message> addMessage(JAXBElement<Message> message) {
		messages.add(message.getValue());
		return messages;
	}
	
	
	
	
	
	
	
	
	
	
}
