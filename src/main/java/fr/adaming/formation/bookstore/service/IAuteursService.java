package fr.adaming.formation.bookstore.service;

import java.util.List;
import org.springframework.stereotype.Service;
import fr.adaming.formation.bookstore.model.Auteurs;

@Service
public interface IAuteursService {
	
	public Auteurs saveAuteur(Auteurs auteur);
	public void deleteAuteurs(long id);
	public Auteurs getOneAuteurs(long id);
	public List<Auteurs> getAll();
	List<Auteurs> findALL();
	
		
		
	

}
