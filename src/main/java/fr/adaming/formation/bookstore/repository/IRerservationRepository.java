package fr.adaming.formation.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import fr.adaming.formation.bookstore.model.Reservation;

public interface IRerservationRepository extends JpaRepository<Reservation,Long>{


}
