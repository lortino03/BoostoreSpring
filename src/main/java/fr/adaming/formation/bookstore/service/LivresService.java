package fr.adaming.formation.bookstore.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.adaming.formation.bookstore.model.Auteurs;
import fr.adaming.formation.bookstore.model.Categorie;
import fr.adaming.formation.bookstore.model.Etagere;
import fr.adaming.formation.bookstore.model.Livres;
import fr.adaming.formation.bookstore.repository.IAuteursRepository;
import fr.adaming.formation.bookstore.repository.ICategorieRepository;
import fr.adaming.formation.bookstore.repository.IEtagereRepository;
import fr.adaming.formation.bookstore.repository.ILivresRepository;

@Service
public class LivresService implements ILivresService{
	
	
	@Autowired	                       // laisse a spring de gerer  l'instanciation
	ILivresRepository livreRepository;
	@Autowired
	IAuteursRepository auteursRepository;
	@Autowired
	ICategorieRepository categorieRepository;
	@Autowired
	IEtagereRepository etagereRepository;
	
	
	public Livres saveLivre(Livres livre) {
		return livreRepository.save(livre);
	}

	@Override
	public void deleteLivre(long id) {
		livreRepository.deleteById(id);
	}
	
	@Override
	public boolean deleteLivre2(long id) {
		try {
			livreRepository.deleteById(id);
		} catch (Exception e) {
			return false;
		}
	return true;
	}

	public Livres getOneLivre(long id) {
		Optional <Livres> livreOptional=livreRepository.findById(id);
		Livres livre= new Livres();
		if (livreOptional.isPresent()) {
			livre=livreOptional.get();
		}
		return livre;
	}	

	public List<Livres> getAll() {
		return livreRepository.findAll();
	}

	@Override
	public List<Livres> findByTitre(String titre) {
		
		return livreRepository.findByTitre(titre);
	}
	
	
	

	@Override
	public List<Livres> findByAuteur(long idAuteur) {
		Auteurs auteur=auteursRepository.findById(idAuteur).get(); 
		return livreRepository.findByAuteur(auteur);
	}

	@Override
	public List<Livres> findByCategorie(long idCategorie) {
		Categorie categorie= categorieRepository.findById(idCategorie).get();
		return livreRepository.findByCategorie(categorie);
	}

	@Override
	public List<Livres> findByEtagere(long idEtagere) {
	Etagere etagere=etagereRepository.findById(idEtagere).get();
	return livreRepository.findByEtagere(etagere);
	}

	

	
}
