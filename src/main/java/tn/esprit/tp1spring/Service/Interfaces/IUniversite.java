package tn.esprit.tp1spring.Service.Interfaces;

import tn.esprit.tp1spring.Entity.Universite;

import java.util.List;

public interface IUniversite {
    List<Universite> retrieveAllUniversities();
    Universite addUniversite (Universite u);
    Universite updateUniversite (Universite u);
    Universite retrieveUniversite (long idUniversite);
    void removeUniversite (long idUniversite);
//fonction avancée
    Universite affecterFoyerAUniversite(long idFoyer, String nomuniversite);
    Universite desaffecterFoyerAUniversite(long idUniversite);
}
