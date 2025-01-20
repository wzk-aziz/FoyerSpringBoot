package tn.esprit.tp1spring.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.esprit.tp1spring.Entity.Reservation;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface ReservationRepo extends JpaRepository<Reservation, Long> {
    @Query("SELECT r FROM Reservation r JOIN r.Etudiants e WHERE r.chambre.bloc.idBloc = :idBloc AND e.cin = :cin")
   Reservation findReservationByBlocAndCin(long idBloc, long cin);



    @Query("SELECT r FROM Reservation r JOIN r.Etudiants e WHERE e.cin = :cin")
    Reservation findReservationByCin(long cin);

    @Query("SELECT r FROM Reservation r WHERE r.anneeUniversitaire = :anneeUniversitaire AND r.chambre.bloc.foyer.universite.nomuniversite = :nomUniversite")
    List<Reservation> findReservationsByAnneeUniversitaireAndNomUniversite(Date anneeUniversitaire, String nomUniversite);

}