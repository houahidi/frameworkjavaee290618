package fr.orsys.bibliotheque.modele;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
//@DiscriminatorValue("C")
public class CD extends Media {
	
	private float duree;
	private int pistes;

	public CD() {
	}	
	
	public CD(long idMedia, String titre, Date datePublication, float duree, int pistes) {
		super(idMedia, titre, datePublication);
		this.duree = duree;
		this.pistes = pistes;
	}

	public float getDuree() {
		return duree;
	}


	public void setDuree(float duree) {
		this.duree = duree;
	}


	public int getPistes() {
		return pistes;
	}


	public void setPistes(int pistes) {
		this.pistes = pistes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Float.floatToIntBits(duree);
		result = prime * result + pistes;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		CD other = (CD) obj;
		if (Float.floatToIntBits(duree) != Float.floatToIntBits(other.duree))
			return false;
		if (pistes != other.pistes)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CD [duree=" + duree + ", pistes=" + pistes + "]";
	}

	
}
