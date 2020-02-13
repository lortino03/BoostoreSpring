package fr.adaming.formation.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import fr.adaming.formation.bookstore.model.Reservation;
import fr.adaming.formation.bookstore.service.IReservationService;


@RestController
@RequestMapping("reservation")
@CrossOrigin("http://localhost:4200")
public class ReservationController {
	
	@Autowired
	IReservationService reservationService;
	

	@GetMapping // WEBSERVICE AFFCICHER TOUTES LES RESA

	public List<Reservation> getAll() {
		return reservationService.getAll();
	}
	
	@GetMapping("{id}") // WEBSERVICE RECUPERER UNE RESRVATION

	public Reservation getOne(@PathVariable long id) {
		return reservationService.getOneReservation(id);
	}

	

	@DeleteMapping("{id}") // WEBSERVICE SUPPRIMER RESA
	public void deleteReservation(@PathVariable long id) {
		reservationService.deleteReservation(id);
	}
	
	@PostMapping // WEBSERVICE CREATTION DEES RESA
	public Reservation saveReservation(@RequestBody Reservation reservation) {
//		Reservation res=new Reservation();
//		res.setLivres(reservation.getLivres());
//		res.setUtilisateurs(reservation.getUtilisateurs());
		return reservationService.saveReservation(reservation);
	}
	
}
