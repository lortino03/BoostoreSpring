package fr.adaming.formation.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.adaming.formation.bookstore.model.Categorie;
import fr.adaming.formation.bookstore.model.Livres;
import fr.adaming.formation.bookstore.repository.ICategorieRepository;

@Service
public class CategorieService implements ICategorieService{
	
	@Autowired
	ICategorieRepository categorieRepository;

	@Override
	public Categorie saveCategorie(Categorie categorie) {
	
		return categorieRepository.save(categorie);
	}

	@Override
	public void deleteCategorie(long id) {
		categorieRepository.deleteById(id);
		
	}

	@Override
	public Categorie getOneCategorie(long id) {
		Optional <Categorie> categorieOptional=categorieRepository.findById(id);
		Categorie categorie= new Categorie();
		if (categorieOptional.isPresent()) {
			categorie=categorieOptional.get();
		}
		return categorie;
	}

	@Override
	public List<Categorie> getAll() {
		
		return categorieRepository.findAll();
	}

}
