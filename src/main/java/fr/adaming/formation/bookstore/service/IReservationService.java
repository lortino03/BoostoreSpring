package fr.adaming.formation.bookstore.service;

import java.util.List;


import org.springframework.stereotype.Service;
import fr.adaming.formation.bookstore.model.Reservation;

@Service
public interface IReservationService {
	public Reservation saveReservation(Reservation reserver);
	public void deleteReservation(long id);
	public boolean deleteReservation2(long id);
	public Reservation getOneReservation(long id);
	public List<Reservation> getAll();
	public List<Reservation> findByUtilisateurs(long idUtilisateur);

}
