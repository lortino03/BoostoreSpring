package fr.adaming.formation.bookstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import fr.adaming.formation.bookstore.model.Categorie;


public interface ICategorieRepository extends JpaRepository<Categorie, Long> {


}
