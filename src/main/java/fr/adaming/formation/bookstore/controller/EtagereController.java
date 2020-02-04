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
import fr.adaming.formation.bookstore.model.Etagere;
import fr.adaming.formation.bookstore.service.IEtagereService;

@RestController
@RequestMapping("categorie")
@CrossOrigin("http://localhost:4200")
public class EtagereController {
	@Autowired
	IEtagereService etagereService;
	
	@GetMapping
	public List<Etagere> getAll() {
		return etagereService.getAll();
	}
	
	@GetMapping("{id}") 					

	public Etagere getOne(@PathVariable long id) { 
													
		return etagereService.getOneEtagere(id);

	}
	
	@DeleteMapping("{id}") 
	public void deleteEtagere(@PathVariable long id) {
		etagereService.deleteEtagere(id);
		
		
	}

	@PostMapping
	public Etagere saveEtagere(@RequestBody Etagere etagere) {
		return etagereService.saveEtagere(etagere);
		
	}
	
	@PutMapping
	public Etagere updateEtagere(@RequestBody Etagere etagere) {
		return etagereService.saveEtagere(etagere);
		
	}
	
	
	

}
