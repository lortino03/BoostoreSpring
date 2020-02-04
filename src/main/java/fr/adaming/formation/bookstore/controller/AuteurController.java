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
import fr.adaming.formation.bookstore.model.Auteurs;
import fr.adaming.formation.bookstore.service.IAuteursService;

@RestController
@RequestMapping("auteurs")
@CrossOrigin("http://localhost:4200")
public class AuteurController {
	
	@Autowired
	IAuteursService auteursService;
	
	@GetMapping 									  // pour dire que ce sera une methode au niveau des methodes http, on peut avoir// postmapping, putmapping
	public List<Auteurs> getAll() {
		return auteursService.getAll();
	}

	@GetMapping("{id}") 							  // pour un getOne , On a besoin d'un id, le id ici est ceci correspond a ce que nous faisions dans postman /:

	public Auteurs getOne(@PathVariable long id) {    // pour dire que c'est un parametre a prendre de l'url, pour recuperer du corps on mettra @requestBody
													
		return auteursService.getOneAuteurs(id);

	}
	
	@DeleteMapping("{id}") 
	public void deleteAuteurs(@PathVariable long id) {
		auteursService.deleteAuteurs(id);
	}
	
	@PostMapping
	public Auteurs addAuteurs(@RequestBody Auteurs auteur) {
		return auteursService.saveAuteur(auteur);
		}
	

	@PutMapping
	public Auteurs updateAuteurs(@RequestBody Auteurs auteur) {
		return auteursService.saveAuteur(auteur);
		
	}
	

}
