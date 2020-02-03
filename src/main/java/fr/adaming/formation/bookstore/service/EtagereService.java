package fr.adaming.formation.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.adaming.formation.bookstore.model.Auteurs;
import fr.adaming.formation.bookstore.model.Etagere;
import fr.adaming.formation.bookstore.repository.IEtagereRepository;

@Service
public class EtagereService implements IEtagereService {

	
	
	@Autowired
	IEtagereRepository etagereRepository;
	
	
	@Override
	public Etagere saveEtagere(Etagere etagere) {
		
		return etagereRepository.save(etagere);
	}

	@Override
	public void deleteEtagere(Etagere etagere) {	
	}

	@Override
	public Etagere getOneEtagere(long id) {
		Optional<Etagere>etagereOptional=etagereRepository.findById(id);
		Etagere etagere=new Etagere();
		if (etagereOptional.isPresent()) {
		etagere=etagereOptional.get();
		}
		return etagere;
	}
	
	
	@Override
	public List<Etagere> findALL(Etagere etagere) {
		
		return etagereRepository.findAll();
	}

}
