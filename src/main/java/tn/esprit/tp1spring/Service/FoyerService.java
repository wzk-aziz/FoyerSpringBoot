package tn.esprit.tp1spring.Service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tp1spring.Entity.Bloc;
import tn.esprit.tp1spring.Entity.Foyer;
import tn.esprit.tp1spring.Entity.Universite;
import tn.esprit.tp1spring.Repository.FoyerRepo;
import tn.esprit.tp1spring.Repository.UniversiteRepo;
import tn.esprit.tp1spring.Service.Interfaces.IFoyer;

import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor

public class FoyerService implements IFoyer {

    FoyerRepo foyerRepo;
    UniversiteRepo universiteRepo;
    @Override
    public List<Foyer> retrieveAllFoyers() {
        return foyerRepo.findAll();
    }

    @Override
    public Foyer addFoyer(Foyer f) {
        return foyerRepo.save(f);
    }

    @Override
    public Foyer updateFoyer(Foyer f) {
        return foyerRepo.save(f);
    }

    @Override
    public Foyer retrieveFoyer(long idFoyer) {
        return foyerRepo.findById(idFoyer).get();
    }

    @Override
    public void removeFoyer(long idFoyer) {
        foyerRepo.deleteById(idFoyer);
    }

    @Override
    public Foyer ajouterFoyerEtAffecterAUniversite(Foyer foyer, String nomuniversite) {
        Universite universite = universiteRepo.findBynomuniversite(nomuniversite)
                .orElseThrow(() -> new RuntimeException("Université non trouvée"));

        // Assurer les affectations nécessaires
        Set<Bloc> blocs = foyer.getBlocs();
        for (Bloc bloc : blocs) {
            bloc.setFoyer(foyer);
        }

        foyer.setUniversite(universite);
        return foyerRepo.save(foyer);
    }



}
