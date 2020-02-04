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
import fr.adaming.formation.bookstore.model.Categorie;
import fr.adaming.formation.bookstore.service.ICategorieService;

@RestController
@RequestMapping("categorie")
@CrossOrigin("http://localhost:4200")
public class CategorieController {
	@Autowired
	ICategorieService categorieService;
	
	@GetMapping
	public List<Categorie> getAll() {
		return categorieService.getAll();
	}
	
	@GetMapping("{id}") 					

	public Categorie getOne(@PathVariable long id) { 
													
		return categorieService.getOneCategorie(id);

	}
	
	@DeleteMapping("{id}") 
	public void deleteCategorie(@PathVariable long id) {
		categorieService.deleteCategorie(id);
		
		
	}

	@PostMapping
	public Categorie saveCategorie(@RequestBody Categorie categorie) {
		return categorieService.saveCategorie(categorie);
		
	}
	
	@PutMapping
	public Categorie updateCategorie(@RequestBody Categorie categorie) {
		return categorieService.saveCategorie(categorie);
		
	}
	

}
