package fr.adaming.formation.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import fr.adaming.formation.bookstore.model.Auteurs;
import fr.adaming.formation.bookstore.repository.IAuteursRepository;

@Service
public class AuteursService implements IAuteursService{

		@Autowired
		IAuteursRepository auteurRepository;
		
	@Override
	public Auteurs saveAuteur(Auteurs auteur) {
		return auteurRepository.save(auteur);
	}

	@Override
	public void deleteAuteurs(long id) {
		auteurRepository.deleteById(id);
		
	}

	@Override
	public Auteurs getOneAuteurs(long id) {
		Optional<Auteurs>auteursOptional=auteurRepository.findById(id);
		Auteurs auteur= new Auteurs();
		if(auteursOptional.isPresent()) {
			auteur=auteursOptional.get();
		}
		return auteur;
	}

	@Override
	public List<Auteurs> findALL() {
	
		return auteurRepository.findAll();
	}

	@Override
	public List<Auteurs> getAll() {
		
		return auteurRepository.findAll();
	}
	
	
	

}
