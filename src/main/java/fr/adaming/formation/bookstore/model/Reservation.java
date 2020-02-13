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
@Table(name="tb_reservation")
public class Reservation {
	private long idReservation;
	private Livres livres;
	private Utilisateurs utilisateurs;
	private Date date;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	
	 // getters et setters
				
				@Column(name="IdResa")
				public long getIdReservation() {
				    return idReservation;
				}
				public void setIdReservation(long idReservation) {
					this.idReservation = idReservation;
				}
				public void setLivres(Livres livres) {
					this.livres = livres;
				}
				@ManyToOne
				@JoinColumn(name="id_livre")
				public Livres getLivres() {
					return livres;
				}
				@ManyToOne
				@JoinColumn(name="id_utilisateur")
				public Utilisateurs getUtilisateurs() {
					return utilisateurs;
				}
				public void setUtilisateurs(Utilisateurs utilisateurs) {
					this.utilisateurs = utilisateurs;
				}
				@Column(name="Date")
				@JsonFormat(pattern = "yyyy-MM-dd")
				public Date getDate() {
					return date;
				}
				public void setDate(Date date) {
					this.date = date;

				// constructeurs
			
				
				
				}
	public Reservation(long idReservation, Livres livres, Utilisateurs utilisateurs, Date date) {
					super();
					this.idReservation = idReservation;
					this.livres = livres;
					this.utilisateurs = utilisateurs;
					this.date = date;
				}
	
	public Reservation() {
		super();
	}
	@Override
				public String toString() {
					return "Reservation [livres=" + livres + ", utilisateurs=" + utilisateurs + ", date=" + date + "]";
				}

}
