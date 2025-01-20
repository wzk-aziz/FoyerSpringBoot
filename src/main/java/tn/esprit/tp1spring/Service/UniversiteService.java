package tn.esprit.tp1spring.Service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tp1spring.Entity.Foyer;
import tn.esprit.tp1spring.Entity.Universite;
import tn.esprit.tp1spring.Repository.FoyerRepo;
import tn.esprit.tp1spring.Repository.UniversiteRepo;
import tn.esprit.tp1spring.Service.Interfaces.IUniversite;

import java.util.List;

@Service
@AllArgsConstructor
public class UniversiteService implements IUniversite {

    UniversiteRepo universiteRepo;
    FoyerRepo FoyerRepo;

    @Override
    public List<Universite> retrieveAllUniversities() {
        return universiteRepo.findAll();
    }


    @Override
    public Universite addUniversite(Universite u) {
        return universiteRepo.save(u);
    }

    @Override
    public Universite updateUniversite(Universite u) {
        return universiteRepo.save(u);
    }

    @Override
    public Universite retrieveUniversite(long idUniversite) {
        return universiteRepo.findById(idUniversite).get();
    }

    @Override
    public void removeUniversite(long idUniversite) {
        universiteRepo.deleteById(idUniversite);
    }

    @Override
    public Universite affecterFoyerAUniversite(long idFoyer, String nomuniversite) {
        //affecter un foyer à une université
        //1 trouvez si il ya un foyer avec l'id donné
        //2 trouvez si il ya une université avec le nom donné
    Foyer foyer = FoyerRepo.findById(idFoyer).orElseThrow(() -> new RuntimeException("Foyer non trouvé"));
    Universite universite = universiteRepo.findBynomuniversite(nomuniversite).orElseThrow(() -> new RuntimeException("Universite non trouvée"));
    universite.setFoyer(foyer);
    return universiteRepo.save(universite);
}
    @Override
    public Universite desaffecterFoyerAUniversite(long idUniversite) {
        Universite universite = universiteRepo.findById(idUniversite).orElseThrow(() -> new RuntimeException("Universite non trouvée"));
        universite.setFoyer(null);
        return universiteRepo.save(universite);
    }

}
