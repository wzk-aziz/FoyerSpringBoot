package tn.esprit.tp1spring.Service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tp1spring.Entity.*;
import tn.esprit.tp1spring.Repository.BlocRepo;
import tn.esprit.tp1spring.Repository.ChambreRepo;
import tn.esprit.tp1spring.Repository.EtudiantRepo;
import tn.esprit.tp1spring.Repository.ReservationRepo;
import tn.esprit.tp1spring.Service.Interfaces.IReservation;

import java.util.*;

@Service
@AllArgsConstructor
public class ReservationService implements IReservation {

    ReservationRepo reservationRepo;
    ChambreRepo chambreRepo;
    EtudiantRepo etudiantRepo;
    BlocRepo blocRepo;

    @Override
    public List<Reservation> retrieveAllReservation() {
        return reservationRepo.findAll();
    }

    @Override
    public Reservation updateReservation(Reservation res) {
        return reservationRepo.save(res);
    }

    @Override
    public Reservation retrieveReservation(String idReservation) {
        return reservationRepo.findById(Long.valueOf(idReservation)).get();
    }

    @Override
    public Reservation addReservation(Reservation r) {
        return reservationRepo.save(r);
    }

    @Override
    public void removeReservation(String idReservation) {
        reservationRepo.deleteById(Long.valueOf(idReservation));
    }

    @Override
    public Reservation ajouterReservation(long idBloc, long cinEtudiant) {
        Reservation existingReservation = reservationRepo.findReservationByBlocAndCin(idBloc, cinEtudiant);

        if (existingReservation != null) {
            return existingReservation;
        }

        Bloc bloc = blocRepo.findById(idBloc).orElse(null);
        Etudiant etudiant = etudiantRepo.findByCin(cinEtudiant);

        if (bloc != null && etudiant != null) {
            for (Chambre chambre : bloc.getChambres()) {
                int maxCapacity = getMaxCapacity(chambre.getTypeChambre());

                if (chambre.getReservations().size() < maxCapacity) {
                    Reservation reservation = new Reservation();
                    reservation.setIdReservation(chambre.getNumeroChambre() + "-" + bloc.getNomBloc() + "-" + new Date().getYear());
                    reservation.setAnneeUniversitaire(new Date());
                    reservation.setEstValide(true);

                    Set<Etudiant> etudiants = new HashSet<>();
                    etudiants.add(etudiant);
                    reservation.setEtudiants(etudiants);

                    chambre.getReservations().add(reservation);
                    chambreRepo.save(chambre);

                    return reservationRepo.save(reservation);
                }
            }
        }

        return null;
    }

    private int getMaxCapacity(TypeChambre typeChambre) {
        switch (typeChambre) {
            case SIMPLE:
                return 1;
            case DOUBLE:
                return 2;
            case TRIPLE:
                return 3;
            default:
                return 0;
        }
    }

    @Override
    public Reservation annulerReservation(long cinEtudiant) {
        Etudiant etudiant = etudiantRepo.findByCin(cinEtudiant);
        if (etudiant != null) {
            Reservation reservation = reservationRepo.findReservationByCin(cinEtudiant);
            if (reservation != null) {
                reservation.setEstValide(false);
                reservation.getEtudiants().remove(etudiant);
                etudiant.getReservations().remove(reservation);
                etudiantRepo.save(etudiant);

                Chambre chambre = reservation.getChambre();
                if (chambre != null) {
                    chambre.getReservations().remove(reservation);
                    chambreRepo.save(chambre);
                }

                return reservationRepo.save(reservation);
            }
        }
        return null;
    }

    @Override
    public List<Reservation> getReservationParAnneeUniversitaireEtNomUniversite(Date anneeUniversitaire, String nomUniversite) {
        return reservationRepo.findReservationsByAnneeUniversitaireAndNomUniversite(anneeUniversitaire, nomUniversite);
    }
}