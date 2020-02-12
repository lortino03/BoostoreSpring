package fr.adaming.formation.bookstore.controller;

import java.security.Key;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import fr.adaming.formation.bookstore.model.Token;
import fr.adaming.formation.bookstore.model.Utilisateurs;
import fr.adaming.formation.bookstore.service.IUtilisateursService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@RestController
@RequestMapping("utilisateurs")
@CrossOrigin("http://localhost:4200")
public class UtilisateursController {

	Key keys = Keys.secretKeyFor(SignatureAlgorithm.HS256); // encodage de l'algorythm d'encodage

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

	@PostMapping("/connexion") // WebSERVICE POUR SE CONNECTER
	public Utilisateurs AfficherUtilisateurParLog(@RequestBody Utilisateurs utilisateurs) {
		return utilisateursService.findByLogin(utilisateurs);
	}

	@PostMapping("/connexbool") // WebSERVICE POUR SE CONNECTER
	public Boolean AfficherUtilisateurParLogin1(@RequestBody Utilisateurs utilisateurs) {
		return utilisateursService.findByLogin1(utilisateurs);
	}
	
	
	@PostMapping("/token") // WEBSERVICE APOUR SE CONNECTER AVEC TOKEN
	public Token AfficherUtilisateurParLogin(@RequestBody Utilisateurs utilisateurs) {
		Utilisateurs util = new Utilisateurs();
		util = utilisateursService.findByLogin(utilisateurs);
		if (util != null) {
			if (bCryptPasswordEncoder.matches(utilisateurs.getPwd(), util.getPwd()))
				;
			{
				Map<String, Object> claims = new HashMap<String, Object>();
				claims.put("idUtilisateur", util.getIdUtilisateur());
				claims.put("idLogin", util.getLogin());
				claims.put("idpwd", util.getPwd());
				String jws = Jwts.builder().addClaims(claims).signWith(keys).compact(); // specifier la clé d'encodage
				// jws contiendra la chaine de caratere du token						// et pour ca , on instancie
																						// cette clé en haut la, le . compact() ferme le token
 				Token t = new Token();				// crée pour l'envoyer sous forme de JSOn avec le webserv qu'on a cree
				t.setToken(jws);
				return t;

			}
		}
		return null;
	}
}
