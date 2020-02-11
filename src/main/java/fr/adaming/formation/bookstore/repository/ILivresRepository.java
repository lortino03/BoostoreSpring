package fr.adaming.formation.bookstore.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import fr.adaming.formation.bookstore.model.Auteurs;
import fr.adaming.formation.bookstore.model.Categorie;
import fr.adaming.formation.bookstore.model.Etagere;
import fr.adaming.formation.bookstore.model.Livres;

public interface ILivresRepository extends JpaRepository<Livres, Long>{

	public List<Livres> findByTitre(String titre);// les données ici sont conforme a l'attribut dans model, puis on va  dans Iservice 
	public List<Livres>findByAuteur(Auteurs auteur);
	public List<Livres>findByCategorie(Categorie categorie);
	public List<Livres>findByEtagere(Etagere etagere);
	
	

}
