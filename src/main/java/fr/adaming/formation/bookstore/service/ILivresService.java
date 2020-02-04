package fr.adaming.formation.bookstore.service;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.adaming.formation.bookstore.model.Livres;

@Service											// pour dire que c'est un service
public interface ILivresService {	
	
	public Livres saveLivre(Livres livre);
	public void deleteLivre(long id);
	public Livres getOneLivre(long id);
	public List<Livres> getAll();
	
}
