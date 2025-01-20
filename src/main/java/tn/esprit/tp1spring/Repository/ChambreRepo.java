package tn.esprit.tp1spring.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.esprit.tp1spring.Entity.Chambre;
import tn.esprit.tp1spring.Entity.TypeChambre;

import java.util.List;

@Repository
public interface ChambreRepo extends JpaRepository<Chambre, Long> {
    List<Chambre> findAllByNumeroChambreIn(List<Long> numChambres);
    List<Chambre> findByBlocFoyerUniversiteNomuniversite(String nomuniversite);

//    @Query("SELECT c FROM Chambre c WHERE c.bloc.foyer.universite.nomuniversite = :nomUniversite")
//    List<Chambre> findChambresByNomUniversite(String nomUniversite);

    @Query("SELECT c FROM Chambre c WHERE c.bloc.idBloc = :idBloc AND c.typeChambre = :typeC")
    List<Chambre> findChambresByBlocAndType(long idBloc, TypeChambre typeC);

    @Query("SELECT c FROM Chambre c WHERE c.bloc.foyer.universite.nomuniversite = :nomUniversite AND c.typeChambre = :typeC AND c.idChambre NOT IN (SELECT r.chambre.idChambre FROM Reservation r WHERE r.anneeUniversitaire = CURRENT_DATE)")

    List<Chambre> findNonReservedChambresByNomUniversiteAndTypeChambre(String nomUniversite, TypeChambre typeC);

    @Query("SELECT c FROM Chambre c WHERE c.idChambre NOT IN (SELECT r.chambre.idChambre FROM Reservation r WHERE YEAR(r.anneeUniversitaire) = YEAR(CURRENT_DATE))")
    List<Chambre> findUnreservedChambresForCurrentYear();
}
