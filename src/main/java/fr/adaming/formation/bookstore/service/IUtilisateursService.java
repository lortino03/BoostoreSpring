package fr.adaming.formation.bookstore.service;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.adaming.formation.bookstore.model.Utilisateurs;

@Service
public interface IUtilisateursService {
	
	public Utilisateurs getOneUtilisateur(long id);
	public Utilisateurs saveUtilisateurs(Utilisateurs utilisateurs);
	public void deleteUtilisateurs(long id);
	public boolean deleteUtilisateur(long id);
	public List<Utilisateurs> getAll();
	public Utilisateurs findByLoginAndPwd(String login,String pwd);
	public boolean findByLogin1(Utilisateurs utilisateurs);
	public Utilisateurs findByLogin(Utilisateurs utilisateurs);
}
