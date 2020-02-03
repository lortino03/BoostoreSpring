package fr.adaming.formation.bookstore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_etagere")
public class Etagere {
	
	
	private long idEtagere;
	private String libelle;
	
	
			// getters et setters 
					
					@Id
					@GeneratedValue(strategy = GenerationType.IDENTITY)
					@Column(name="id_etagere")
					public long getIdEtagere() {
						return idEtagere;
					}
					public void setIdEtagere(long idEtagere) {
						this.idEtagere = idEtagere;
					}
					@Column(name="libelle_auteur")
					public String getLibelle() {
						return libelle;
					}
					public void setLibelle(String libelle) {
						this.libelle = libelle;
					}
					
				// Constructeur
	public Etagere() {

	}
	public Etagere(String libelle) {
	
		this.libelle = libelle;
	}
	
	@Override
	public String toString() {
		return "Etagere [idEtagere=" + idEtagere + ", libelle=" + libelle + "]";
	}
	
	
	

}
