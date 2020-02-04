package fr.adaming.formation.bookstore.service;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.adaming.formation.bookstore.model.Livres;

@Service											// pour dire que c'est un service
public interface ILivresService {
	
	
	
	public Livres saveLivre(Livres livre);
	public void deleteLivre(Livres livre);
	public Livres getOneLivre(Long id);
	public List<Livres> findALL(Livres livre);
	
}
