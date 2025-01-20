package tn.esprit.tp1spring.Service;

import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.tp1spring.Entity.Chambre;
import tn.esprit.tp1spring.Entity.TypeChambre;
import tn.esprit.tp1spring.Repository.ChambreRepo;
import tn.esprit.tp1spring.Service.Interfaces.IChambre;

import java.util.List;
@Service
@AllArgsConstructor
public class ChambreService implements IChambre {

    ChambreRepo chambreRepo;

    @Override
    public List<Chambre> retrieveAllChambres() {
        return chambreRepo.findAll();
    }

    @Override
    public Chambre addChambre(Chambre c) {
        return chambreRepo.save(c);
    }

    @Override
    public Chambre updateChambre(Chambre c) {
        return chambreRepo.save(c);
    }

    @Override
    public Chambre retrieveChambre(long idChambre) {
        return chambreRepo.findById(idChambre).get();
    }

    @Override
    public void removeChambre(long idChambre) {
        chambreRepo.deleteById(idChambre);
    }

    @Override
    public List<Chambre> GetChambresParNomUniversite(String nomUniversite) {
    return chambreRepo.findByBlocFoyerUniversiteNomuniversite(nomUniversite);
    }

    @Override
    public List<Chambre> getChambresParBlocEtType(long idBloc, TypeChambre typeC) {
        return chambreRepo.findChambresByBlocAndType(idBloc, typeC);
    }


   @Override
    public List<Chambre> getChambresNonReserveParNomUniversiteEtTypeChambre(String nomUniversite, TypeChambre typeC) {
        return chambreRepo.findNonReservedChambresByNomUniversiteAndTypeChambre(nomUniversite, typeC);
    }
    @Override
    public List<Chambre> getUnreservedChambresForCurrentYear() {
        return chambreRepo.findUnreservedChambresForCurrentYear();
    }

    @Scheduled(cron = "0 0 0 * * ?") // This cron expression schedules the task to run daily at midnight
    public void displayUnreservedChambres() {
        List<Chambre> unreservedChambres = getUnreservedChambresForCurrentYear();
        unreservedChambres.forEach(chambre -> System.out.println("Unreserved Chambre: " + chambre));
    }

}
