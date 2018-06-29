package fr.orsys.bibliotheque.modele;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_categorie")
public class Categorie implements Entite<Long>{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idCategorie;
	
	@Column(length=30, unique=true)
	private String labelle;	
	
	public Categorie() {
	}
	
	
	public Categorie(long idCategorie, String labelle) {
		super();
		this.idCategorie = idCategorie;
		this.labelle = labelle;
	}
	public long getIdCategorie() {
		return idCategorie;
	}
	public void setIdCategorie(long idCategorie) {
		this.idCategorie = idCategorie;
	}
	public String getLabelle() {
		return labelle;
	}
	public void setLabelle(String labelle) {
		this.labelle = labelle;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int)idCategorie;
		result = prime * result + ((labelle == null) ? 0 : labelle.hashCode());
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
		Categorie other = (Categorie) obj;
		if (idCategorie != other.idCategorie)
			return false;
		if (labelle == null) {
			if (other.labelle != null)
				return false;
		} else if (!labelle.equals(other.labelle))
			return false;
		return true;
	}


	@Override
	public Long getIdentifiant() {		
		return idCategorie;
	}


}
