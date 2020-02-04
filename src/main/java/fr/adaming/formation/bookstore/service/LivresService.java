package fr.adaming.formation.bookstore.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import fr.adaming.formation.bookstore.model.Livres;
import fr.adaming.formation.bookstore.repository.ILivresRepository;

@Service
public class LivresService implements ILivresService{
	
	
	@Autowired	                       // laisse a spring de gerer  l'instanciation
	ILivresRepository livreRepository;

	
	public Livres saveLivre(Livres livre) {
		return livreRepository.save(livre);
	}

	@Override
	public void deleteLivre(long id) {
		livreRepository.deleteById(id);
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


	
}
