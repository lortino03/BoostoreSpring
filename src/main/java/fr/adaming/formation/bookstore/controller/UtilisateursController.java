package fr.adaming.formation.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import fr.adaming.formation.bookstore.model.Utilisateurs;
import fr.adaming.formation.bookstore.service.IUtilisateursService;

@RestController
@RequestMapping("utilisateurs")
@CrossOrigin("http://localhost:4200")
public class UtilisateursController {

	@Autowired
	IUtilisateursService utilisateursService;

	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	@GetMapping // WEBSERVICE AFFCICHER TOUS LES UTIILISATEURS

	public List<Utilisateurs> getAll() {
		return utilisateursService.getAll();
	}

	@GetMapping("{id}") // WEBSERVICE RECUPERER UN UTILISATEUR

	public Utilisateurs getOne(@PathVariable long id) {
		return utilisateursService.getOneUtilisateur(id);

	}

	@DeleteMapping("{id}") // WEBSERVICE SUPPRIMER UTILISATEUR
	public void deleteUtilisateurs(@PathVariable long id) {
		utilisateursService.deleteUtilisateurs(id);
	}

	@PostMapping // WEBSERVICE CREATTION DES UTILISATEURS
	public Utilisateurs saveUtilisateurs(@RequestBody Utilisateurs utilisateurs) {
		utilisateurs.setPwd(bCryptPasswordEncoder.encode(utilisateurs.getPwd()));
		return utilisateursService.saveUtilisateurs(utilisateurs);

	}

	@PutMapping("{id}") // WEBSERVICE MODIFIER UTILISATEURS
	public Utilisateurs updateUtilisateurs(@PathVariable long id, @RequestBody Utilisateurs utilisateurs) {
		Utilisateurs utilisateur = new Utilisateurs();
		utilisateur = utilisateursService.getOneUtilisateur(id);
		utilisateur.setLogin(utilisateur.getLogin());
		utilisateur.setPwd(utilisateur.getPwd());
		return utilisateursService.saveUtilisateurs(utilisateur);
	}

	@PostMapping("connexion")
	public boolean AfficherUtilisateurParLog(@RequestBody Utilisateurs utilisateurs) {
		return utilisateursService.FindByLogin(utilisateurs);
	}
}
