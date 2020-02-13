package fr.adaming.formation.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import fr.adaming.formation.bookstore.model.Reservation;
import fr.adaming.formation.bookstore.model.Utilisateurs;
import fr.adaming.formation.bookstore.repository.IRerservationRepository;

@Service

public class ReservationService implements IReservationService {
	
	@Autowired
	IRerservationRepository reservationRepository;

	

	@Override
	public Reservation saveReservation(Reservation reserver) {
		return reservationRepository.save(reserver);
	}

	public void deleteReservation(long id) {
		reservationRepository.deleteById(id);;
		
	}

	@Override
	public boolean deleteReservation2(long id) {
		try {
			reservationRepository.deleteById(id);
		} catch (Exception e) {
	return false;
		}
	return true;
	}

	@Override
	public Reservation getOneReservation(long id) {
		Optional<Reservation>ReservationOptional=reservationRepository.findById(id);
		Reservation reservation= new Reservation();
		if (ReservationOptional.isPresent()) {
			reservation=ReservationOptional.get();
		}
		return reservation;
	}

	@Override
	public List<Reservation> getAll() {
		return reservationRepository.findAll();
	}

	@Override
	public List<Reservation> findByUtilisateurs(long idUtilisateur) {

		return null;
	}



}
