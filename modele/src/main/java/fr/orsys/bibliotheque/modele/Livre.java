package fr.orsys.bibliotheque.modele;

import java.util.Date;

public class Livre extends Media {

	private String isbn;
	private int pages;

	public Livre(long idMedia, String titre, Date datePublication, String isbn, int pages) {
		super(idMedia, titre, datePublication);
		this.isbn = isbn;
		this.pages = pages;
	}

	public String getIsbn() {
		return isbn;
	}


	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}


	public int getPages() {
		return pages;
	}


	public void setPages(int pages) {
		this.pages = pages;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		result = prime * result + pages;
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
		Livre other = (Livre) obj;
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
			return false;
		if (pages != other.pages)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Livre [isbn=" + isbn + ", pages=" + pages + "]";
	}


	

}
