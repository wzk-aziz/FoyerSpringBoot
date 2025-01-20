package tn.esprit.tp1spring.Service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tp1spring.Entity.Etudiant;
import tn.esprit.tp1spring.Repository.EtudiantRepo;
import tn.esprit.tp1spring.Service.Interfaces.IEtudiant;

import java.util.List;

@Service
@AllArgsConstructor

public class EtudiantService implements IEtudiant {

    EtudiantRepo etudiantRepo;

    @Override
    public List<Etudiant> retrieveAllEtudiants() {
        return etudiantRepo.findAll();
    }

    @Override
    public List<Etudiant> addEtudiants(List<Etudiant> etudiants) {
        return etudiantRepo.saveAll(etudiants);
    }

    @Override
    public Etudiant updateEtudiant(Etudiant e) {
        return etudiantRepo.save(e);
    }

    @Override
    public Etudiant retrieveEtudiant(long idEtudiant) {
        return etudiantRepo.findById(idEtudiant).get();
    }

    @Override
    public void removeEtudiant(long idEtudiant) {
        etudiantRepo.deleteById(idEtudiant);
    }



}
