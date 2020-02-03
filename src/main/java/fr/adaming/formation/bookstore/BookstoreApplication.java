package fr.adaming.formation.bookstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.adaming.formation.bookstore.model.Livres;
import fr.adaming.formation.bookstore.service.ILivresService;

@SpringBootApplication
public class BookstoreApplication  implements CommandLineRunner{
	@Autowired
	ILivresService livresService;

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Override
	public void run(String...args)throws Exception{
		Livres l1= new Livres();
		l1.setTitre(" l'autoroute du millionnaire");
		l1.setISBN("021324456456");
		
		livresService.saveLivre(l1);
		System.err.println(l1);
		
	}
}
