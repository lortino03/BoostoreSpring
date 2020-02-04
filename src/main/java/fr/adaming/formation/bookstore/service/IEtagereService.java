package fr.adaming.formation.bookstore.service;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.adaming.formation.bookstore.model.Etagere;

@Service
public interface IEtagereService {

	public Etagere saveEtagere(Etagere etagere);
	public void deleteEtagere(long id);
	public Etagere getOneEtagere(long id);
	public List<Etagere> getAll();
}
