package tn.esprit.tp1spring.Service.Interfaces;

import tn.esprit.tp1spring.Entity.Chambre;
import tn.esprit.tp1spring.Entity.TypeChambre;

import java.util.List;

public interface IChambre {
    List<Chambre> retrieveAllChambres();
    Chambre addChambre(Chambre c);
    Chambre updateChambre (Chambre c);
    Chambre retrieveChambre (long idChambre);
    void removeChambre (long idChambre);
   List <Chambre> GetChambresParNomUniversite(String nomUniversité);
    List<Chambre> getChambresParBlocEtType(long idBloc, TypeChambre typeC);
    List<Chambre> getChambresNonReserveParNomUniversiteEtTypeChambre(String nomUniversite, TypeChambre typeC);
    List<Chambre> getUnreservedChambresForCurrentYear();

}
