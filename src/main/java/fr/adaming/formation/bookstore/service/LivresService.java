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

	@Override
	public Livres saveLivre(Livres livre) {
		return livreRepository.save(livre);
	}

	@Override
	public void deleteLivre(Livres livre) {
	}

	public Livres getOneLivre(Long id) {
		Optional <Livres> livreOptional=livreRepository.findById(id);
		Livres livre= new Livres();
		if (livreOptional.isPresent()) {
			livre=livreOptional.get();
		}
		return livre;
	}

	
	@Override
	public List<Livres> findALL(Livres livre) {
		
		return livreRepository.findAll();
	}

}
