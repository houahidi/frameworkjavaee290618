package fr.orsys.bibliotheque.rest;

import javax.ws.rs.GET;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="BaliseMessage")
@XmlAccessorType(XmlAccessType.FIELD)
public class Message {	
	
	private long id;
	
	private String message;
	
	public Message() {
	}

	public long getId() {
		return id;
	}

	public Message(long id, String message) {
		super();
		this.id = id;
		this.message = message;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
