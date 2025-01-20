package tn.esprit.tp1spring.Service.Interfaces;

import tn.esprit.tp1spring.Entity.Foyer;

import java.util.List;

public interface IFoyer {
    List<Foyer> retrieveAllFoyers();
    Foyer addFoyer (Foyer f);
    Foyer updateFoyer (Foyer f);
    Foyer retrieveFoyer (long idFoyer);
    void removeFoyer (long idFoyer);
    Foyer ajouterFoyerEtAffecterAUniversite(Foyer foyer, String nomuniversite);
}
