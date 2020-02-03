package fr.adaming.formation.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.adaming.formation.bookstore.model.Livres;

public interface ILivresRepository extends JpaRepository<Livres, Long>{
	

}
