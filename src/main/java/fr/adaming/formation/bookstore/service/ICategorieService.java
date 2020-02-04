package fr.adaming.formation.bookstore.service;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.adaming.formation.bookstore.model.Categorie;


@Service
public interface ICategorieService {
	public Categorie saveCategorie(Categorie categorie);
	public void deleteCategorie(long id);
	public Categorie getOneCategorie(long id);
	public List<Categorie > getAll();

}
