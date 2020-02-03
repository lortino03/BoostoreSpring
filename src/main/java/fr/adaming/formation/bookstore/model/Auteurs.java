package fr.adaming.formation.bookstore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="td_auteurs")
public class Auteurs {
	
				private long idAuteurs;
				private String nom;	
				private String prenom;
				
				
	
	// getters et setters
				@Id
				@GeneratedValue(strategy = GenerationType.IDENTITY)
				@Column(name="ID")
				public long getIdAuteurs() {
					return idAuteurs;
				}
				public void setIdAuteurs(long idAuteurs) {
					this.idAuteurs = idAuteurs;
				}
				@Column(name="NOM")
				public String getNom() {
					return nom;
				}
				public void setNom(String nom) {
					this.nom = nom;
				}
				@Column(name="PRENOM")
				public String getPrenom() {
					return prenom;
				}
				public void setPrenom(String prenom) {
					this.prenom = prenom;
				}
				
	// constrcuteurs
	
	public Auteurs() {
		
	}
	public Auteurs(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}
	@Override
	public String toString() {
		return "Auteurs [idAuteurs=" + idAuteurs + ", nom=" + nom + ", prenom=" + prenom + "]";
	}
	
	

}
