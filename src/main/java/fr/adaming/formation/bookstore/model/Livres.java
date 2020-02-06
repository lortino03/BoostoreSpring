package fr.adaming.formation.bookstore.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
@Entity
@Table(name="tb_livre")
public class Livres {
	
	private long idLivre;	
	private String ISBN;	
	private String titre;	
	private Auteurs auteur;	
	private Date dateDeParution;	
	private Categorie categorie;	
	private Etagere etagere;
	
	
	// getters et setters

				@Id
				@GeneratedValue(strategy = GenerationType.IDENTITY)
				@Column(name="id_livre")
				public long getIdLivre() {
					return idLivre;
				}
				public void setIdLivre(long idLivre) {
					this.idLivre = idLivre;
				}
				@Column(name="code")
				public String getISBN() {
					return ISBN;
				}
				public void setISBN(String iSBN) {
					ISBN = iSBN;
				}
				@Column(name="Titre")
				public String getTitre() {
					return titre;
				}
				public void setTitre(String titre) {
					this.titre = titre;
				}
				@ManyToOne
				@JoinColumn(name="id_auteur")
				public Auteurs getAuteur() {
					return auteur;
				}
				
				public void setAuteur(Auteurs auteur) {
					this.auteur = auteur;
				}
				@Column(name="date")
				@JsonFormat(pattern = "yyyy-MM-dd")
				public Date getDateDeParution() {
					return dateDeParution;
				}
				public void setDateDeParution(Date dateDeParution) {
					this.dateDeParution = dateDeParution;
				}
							
				@ManyToOne
				@JoinColumn(name="id_categorie")
				public Categorie getCategorie() {
					return categorie;
				}
				public void setCategorie(Categorie categorie) {
					this.categorie = categorie;
				}
				@ManyToOne
				@JoinColumn(name="id_etagere")
				public Etagere getEtagere() {
					return etagere;
				}
				public void setEtagere(Etagere etagere) {
					this.etagere = etagere;
				}

	// Constructeurs
	
	public Livres() {
		
	}
	public Livres(String iSBN, String titre, Auteurs auteur, Date dateDeParution, Categorie categorie, Etagere etagere) {
		super();
		ISBN = iSBN;
		this.titre = titre;
		this.auteur = auteur;
		this.dateDeParution = dateDeParution;
		this.categorie=categorie;
		this.etagere = etagere;
	}
	
	@Override
	public String toString() {
		return "Livres [idLivre=" + idLivre + ", ISBN=" + ISBN + ", titre=" + titre + ", auteur=" + auteur
				+ ", dateDeParution=" + dateDeParution + ", categorie=" + categorie + ", etagere=" + etagere + "]";
	}
	
	
}
