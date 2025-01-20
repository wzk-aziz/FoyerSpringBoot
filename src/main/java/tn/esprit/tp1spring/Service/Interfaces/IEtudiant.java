package tn.esprit.tp1spring.Service.Interfaces;

import tn.esprit.tp1spring.Entity.Etudiant;

import java.util.List;

public interface IEtudiant {

    List<Etudiant> retrieveAllEtudiants();
    List<Etudiant> addEtudiants (List<Etudiant> etudiants);
    Etudiant updateEtudiant (Etudiant e);
    Etudiant retrieveEtudiant(long idEtudiant);
    void removeEtudiant(long idEtudiant);

}
