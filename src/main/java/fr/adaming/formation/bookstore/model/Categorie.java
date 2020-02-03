package fr.adaming.formation.bookstore.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_categorie")
public class Categorie {
	
			
			private long idCategorie;
			private String libelle;
			
			 // getters and setters
			
			@Id
			@GeneratedValue(strategy = GenerationType.IDENTITY)
			@Column(name="id_categorie")
			public long getIdCategorie() {
				return idCategorie;
			}
			public void setIdCategorie(long idCategorie) {
				this.idCategorie = idCategorie;
			}
			@Column(name="Libelle")
			public String getLibelle() {
				return libelle;
			}
			public void setLibelle(String libelle) {
				this.libelle = libelle;
			}
			
			
			// Constructeur
	public Categorie() {
		
	}
	public Categorie(String libelle) {
		this.libelle = libelle;
	}
	
	@Override
	public String toString() {
		return "Categorie [idCategorie=" + idCategorie + ", libelle=" + libelle + "]";
	}
	
	

}
