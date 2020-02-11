package fr.adaming.formation.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.adaming.formation.bookstore.model.Livres;
import fr.adaming.formation.bookstore.service.ILivresService;

@RestController
@RequestMapping("livres") // web service qui va nous donnée des livres
@CrossOrigin("http://localhost:4200") // client qui va consommer

public class LivreController {
	@Autowired
	ILivresService livresService;

	@GetMapping 									// pour dire que ce sera une methode au niveau des methodes http, on peut avoir// postmapping, putmapping
	public List<Livres> getAll() {
		return livresService.getAll();
	}

	 // WEBSERVICE  AFFICHER UTILISATEURS
	@GetMapping("{id}") 							// pour un getOne , On a besoin d'un id, le id ici est ceci correspond a ce que nous faisions dans postman /:

	public Livres getOne(@PathVariable long id) { // pour dire que c'est un parametre a prendre de l'url, pour recuperer du corps on mettra @requestBody
													
		return livresService.getOneLivre(id);

	}
	@GetMapping("byauteur/{idAuteur}")  // WEBSERVICE AFFICHER PAR AUTEUR
	
	public List<Livres>findByAuteur(@PathVariable long idAuteur){
		return livresService.findByAuteur(idAuteur);	
	}
	
	@GetMapping("byEtagere/{idEtagere}")  // WEBSERVICE AFFICHER PAR ETAGERE
	public List<Livres>findByEtagere(@PathVariable long idEtagere){
		return livresService.findByEtagere(idEtagere);
	}
	
	@GetMapping("byCategorie/{idCategorie}") // WEBSERVICE AFFICHER PAR CATEGORIE
	public List<Livres>findByCategorie(@PathVariable long idCategorie){
		return livresService.findByCategorie(idCategorie);		
	}
	
	@DeleteMapping("{id}")  // WEBSERVICE SUPPRIMER LIVRES
	public void deleteLivre(@PathVariable long id) {
		livresService.deleteLivre(id);
		System.out.println("livre supprimé");
		
	}
	

	@PostMapping
	public Livres saveLivres(@RequestBody Livres livre) {
		return livresService.saveLivre(livre);
		
	}
	
	@PutMapping("{id}")
	public Livres updateLivres(@PathVariable long id, @RequestBody Livres livre) {
		Livres l1 = new Livres();
		l1=livresService.getOneLivre(id);
		l1.setTitre(livre.getTitre());
		l1.setISBN(livre.getISBN());
		l1.setAuteur(livre.getAuteur());
		l1.setCategorie(livre.getCategorie());
		l1.setEtagere(livre.getEtagere());
		l1.setDateDeParution(livre.getDateDeParution());
		return livresService.saveLivre(l1);
		
	}
	
}
