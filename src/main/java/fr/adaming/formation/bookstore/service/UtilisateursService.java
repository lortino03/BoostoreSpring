package fr.adaming.formation.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import fr.adaming.formation.bookstore.model.Utilisateurs;
import fr.adaming.formation.bookstore.repository.IUtilisateursRepository;


@Service
public class UtilisateursService implements IUtilisateursService {
	
	@Autowired
	IUtilisateursRepository utilisateursRepository;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public Utilisateurs getOneUtilisateur(long id) {
		Optional<Utilisateurs>UtilisateursOptional=utilisateursRepository.findById(id);
		Utilisateurs utilisateurs= new Utilisateurs();
		if (UtilisateursOptional.isPresent()) {
			utilisateurs=UtilisateursOptional.get();
		}
		return utilisateurs;
	}

	@Override
	public Utilisateurs saveUtilisateurs(Utilisateurs utilisateurs) {
		return utilisateursRepository.save(utilisateurs);
	}

	@Override
	public void deleteUtilisateurs(long id) {
		utilisateursRepository.deleteById(id);
	}

	@Override
	public boolean deleteUtilisateur(long id) {
		try {
			utilisateursRepository.deleteById(id);
		} catch (Exception e) {
	return false;
		}
	return true;
	}

	@Override
	public List<Utilisateurs> getAll() {
		return utilisateursRepository.findAll();
	}

	@Override
	public Utilisateurs FindByLoginAndPwd(String login,String pwd) {
		Utilisateurs utilisateur =new Utilisateurs();
		utilisateur= utilisateursRepository.findByLoginAndPwd(login, pwd);
		if(utilisateur !=null) {
			utilisateur.setPwd("");
			return utilisateur;
		}
		return null;
	}

	@Override
	public boolean FindByLogin(Utilisateurs utilisateurs) {
		Utilisateurs usercripte= utilisateursRepository.findByLogin(utilisateurs .getLogin());
		if(usercripte==null) 
			return false;
		if (bCryptPasswordEncoder.matches(utilisateurs.getPwd(),usercripte.getPwd()));
		return true;
	}
 

}
