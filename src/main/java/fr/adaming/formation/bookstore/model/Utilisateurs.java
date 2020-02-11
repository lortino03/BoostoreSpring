package fr.adaming.formation.bookstore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_utlisateur")
public class Utilisateurs {
	private long idUtilisateur;
	private String login ;
	private String pwd;
	
	
	// getters and setters
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name="ID")
	public long getIdUtilisateur() {
		return idUtilisateur;
	}
	public void setIdUtilisateur(long idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}
	@Column(name="login")
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	@Column(name="pwd")
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	// constructeurs
	
	public Utilisateurs(String login, String pwd) {
		super();
		this.login = login;
		this.pwd = pwd;
	}
	
	public Utilisateurs() {

	}
	// Totstring
	@Override
	public String toString() {
		return "Utilisateurs [login=" + login + ", pwd=" + pwd + "]";
	}
	
	

}
