package tn.esprit.tp1spring.Service.Interfaces;

import tn.esprit.tp1spring.Entity.Reservation;

import java.util.Date;
import java.util.List;

public interface IReservation {
    List<Reservation> retrieveAllReservation();
    Reservation updateReservation(Reservation res);
    Reservation retrieveReservation(String idReservation);
    Reservation addReservation(Reservation r);
    void removeReservation(String idReservation);
    Reservation ajouterReservation(long idBloc, long cin);
    Reservation annulerReservation(long cin);
    List<Reservation> getReservationParAnneeUniversitaireEtNomUniversite(Date anneeUniversitaire, String nomUniversite);

}