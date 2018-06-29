package fr.orsys.bibliotheque.modele;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="t_media")
@Inheritance(strategy=InheritanceType.JOINED)
//@DiscriminatorColumn(name="discrimiant", length=1)
//@DiscriminatorValue("M")

@XmlRootElement(name="media")
@XmlAccessorType(XmlAccessType.FIELD)
public class Media implements Entite<Long> {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ident")
	private long identifiant;
	@Column(length=30, unique=true, nullable=false)
	private String titre;
	@Column(name="date_publ")
	private Date datePublication;
	// 2 questions a se poser pour les associations
	// quelle strategie de chargement
	// quelle strategie de cascade	
	
	@OneToMany(mappedBy="media", 
			   fetch=FetchType.EAGER, 
			   cascade= {CascadeType.PERSIST, CascadeType.REMOVE})
	@XmlTransient
	@JsonIgnore
	private List<Exemplaire> exemplaires;
	
	@ManyToMany
	@JoinTable(name="r_media_categorie",
				joinColumns=@JoinColumn(name="media_id"),
				inverseJoinColumns=@JoinColumn(name="categorie_id")
			)
	@XmlTransient
	@JsonIgnore
	private List<Categorie> categories;
	
	public Media() {
		exemplaires = new ArrayList<>();
		categories = new ArrayList<>();
		System.out.println("Constructeur par defaut");
	}
		
	public Media(long identifiant, String titre, Date datePublication) {
		this();
		System.out.println("Constructeur avec parametres");		
		this.identifiant = identifiant;
		this.titre = titre;
		this.datePublication = datePublication;
		
	}
	
	public Media(long identifiant, String titre) {
		this();
		System.out.println("Constructeur avec parametres");
		this.identifiant = identifiant;
		this.titre = titre;
	}
		
	public Long getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(Long identifiant) {
		this.identifiant = identifiant;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		System.out.println("setTitre");
		this.titre = titre;
	}

	public Date getDatePublication() {
		return datePublication;
	}

	public void setDatePublication(Date datePublication) {
		this.datePublication = datePublication;
	}


	@Override
	public String toString() {
		return "Media [identifiant=" + identifiant + ", titre=" + titre + "]";
	}

	public List<Exemplaire> getExemplaires() {
		return exemplaires;
	}

	public void setExemplaires(List<Exemplaire> exemplaires) {
		this.exemplaires = exemplaires;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (identifiant ^ (identifiant >>> 32));
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
		Media other = (Media) obj;
		if (identifiant != other.identifiant)
			return false;
		return true;
	}	
	
	
	public void addExemplaire(Exemplaire e) {
		if (e!= null && ! exemplaires.contains(e)) {	
			exemplaires.add(e);
			e.setMedia(this);
		}
	}
		

	public void removeExemplaire(Exemplaire e) {
		if (e!= null && exemplaires.contains(e)) {
			exemplaires.remove(e);
			e.setMedia(null);
			
		}
	}

	public List<Categorie> getCategories() {
		return categories;
	}

	public void setCategories(List<Categorie> categories) {
		this.categories = categories;
	}
	
	
	public void addCategorie(Categorie c) {
		if (c!= null && ! categories.contains(c)) {	
			categories.add(c);
		}
	}
		

	public void removeCategorie(Categorie c) {
		if (c!= null &&  categories.contains(c)) {	
			categories.remove(c);
		}
	}
		
	
	

}
