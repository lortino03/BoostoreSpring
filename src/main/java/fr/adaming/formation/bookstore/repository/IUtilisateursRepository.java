package fr.adaming.formation.bookstore.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import fr.adaming.formation.bookstore.model.Utilisateurs;

@Service
public interface IUtilisateursRepository extends JpaRepository<Utilisateurs,Long>{
	public Utilisateurs findByLoginAndPwd(String login,String pwd);
	public Utilisateurs findByLogin(String login);
}
