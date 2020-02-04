package fr.adaming.formation.bookstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import fr.adaming.formation.bookstore.model.Auteurs;
import fr.adaming.formation.bookstore.model.Livres;
import fr.adaming.formation.bookstore.service.IAuteursService;
import fr.adaming.formation.bookstore.service.ICategorieService;
import fr.adaming.formation.bookstore.service.IEtagereService;
import fr.adaming.formation.bookstore.service.ILivresService;

@SpringBootApplication
public class BookstoreApplication  implements CommandLineRunner{
	@Autowired
	ILivresService livresService;
	IAuteursService auteurService;
	ICategorieService categorieService;
	IEtagereService etagereService;
	

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Override
	public void run(String...args)throws Exception{
		Livres l1= new Livres();
//		Auteurs a1=new Auteurs();
//		Categorie c1= new Categorie();
//		Etagere e1= new Etagere();
//		
//		a1.setNom("MJ");
//		a1.setPrenom("DEMARCO");
//		auteurService.saveAuteur(a1);
//	
//		c1.setLibelle("Buisness");
//		categorieService.saveCategorie(c1);
//		e1.setLibelle("premiere etagere");
//		etagereService.saveEtagere(e1);
//		
		l1.setTitre(" l'autoroute du millionnaire");
		l1.setISBN("021324456456");
//		l1.setAuteur(a1);
//		l1.setCategorie(c1);
//		l1.setEtagere(e1);
		
		livresService.saveLivre(l1);
		System.err.println(l1);
		
	}
}
