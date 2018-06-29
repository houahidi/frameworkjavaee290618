package fr.orsys.bibliotheque.modele;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_exemplaire")
public class Exemplaire implements Entite<String> {

	@Id
	private String reference;

	@Enumerated(EnumType.STRING)
	private EtatExemplaire etat;
	
	@ManyToOne
	@JoinColumn(name="media_id")
	private Media media;

	public Exemplaire() {
	}

	public Exemplaire(String reference, EtatExemplaire etat) {		
		this.reference = reference;
		this.etat = etat;
	}
	public Exemplaire(String reference, EtatExemplaire etat, Media media) {
		this.reference = reference;
		this.etat = etat;
		setMedia(media);
		//this.media = media;
	}

	
	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public EtatExemplaire getEtat() {
		return etat;
	}

	public void setEtat(EtatExemplaire etat) {
		this.etat = etat;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((reference == null) ? 0 : reference.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Exemplaire other = (Exemplaire) obj;
		if (reference == null) {
			if (other.reference != null)
				return false;
		} else if (!reference.equals(other.reference))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Exemplaire [reference=" + reference + ", etat=" + etat + "]";
	}

	public Media getMedia() {
		return media;
	}

	public void setMedia(Media media) {
		this.media = media;
		if(media != null) {
			media.addExemplaire(this);
		}
	}

	@Override
	public String getIdentifiant() {		
		return reference;
	}

	
	
}
