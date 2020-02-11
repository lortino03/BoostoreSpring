package fr.adaming.formation.bookstore;

import java.util.Calendar;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import fr.adaming.formation.bookstore.model.Auteurs;
import fr.adaming.formation.bookstore.model.Categorie;
import fr.adaming.formation.bookstore.model.Etagere;
import fr.adaming.formation.bookstore.model.Livres;
import fr.adaming.formation.bookstore.service.IAuteursService;
import fr.adaming.formation.bookstore.service.ICategorieService;
import fr.adaming.formation.bookstore.service.IEtagereService;
import fr.adaming.formation.bookstore.service.ILivresService;
import fr.adaming.formation.bookstore.service.IUtilisateursService;

@SpringBootApplication
public class BookstoreApplication implements CommandLineRunner {
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Autowired
	ILivresService livresService;
	@Autowired
	IAuteursService auteurService;
	@Autowired
	ICategorieService categorieService;
	@Autowired
	IEtagereService etagereService;
	@Autowired
	IUtilisateursService utilisateursService;
	

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Calendar d=Calendar.getInstance();
		d.set(2015, 10, 10);
		Date datesql=new Date(d.getTime().getTime());
		
		Auteurs a1 = new Auteurs();
		a1 = auteurService.getOneAuteurs(1);
		a1.setNom("MJ");
		a1.setPrenom("DEMARCO");
		auteurService.saveAuteur(a1);

		Categorie c1 = new Categorie();
		c1=categorieService.getOneCategorie(1);
		c1.setLibelle("Buisness");
		categorieService.saveCategorie(c1);
		
		
		Etagere e1 = new Etagere();
		e1=etagereService.getOneEtagere(1);
		e1.setLibelle("premiere etagere");
		etagereService.saveEtagere(e1);

		Livres l1 = new Livres();
		l1=livresService.getOneLivre(1);
		l1.setIdLivre(3);
		l1.setTitre(" l'autoroute du millionnaire");
		l1.setISBN("021324456456");
		l1.setAuteur(a1);
		l1.setCategorie(c1);
		l1.setEtagere(e1);
		l1.setDateDeParution(datesql);

//		livresService.saveLivre(l1);

		System.err.println("bouyachaka");

	}
}
