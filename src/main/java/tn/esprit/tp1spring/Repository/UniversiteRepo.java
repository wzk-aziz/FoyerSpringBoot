package tn.esprit.tp1spring.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.tp1spring.Entity.Universite;

import java.util.Optional;

@Repository
public interface UniversiteRepo extends JpaRepository<Universite, Long> {

//Optional container fih objet wela null
    Optional<Universite> findBynomuniversite(String nomuniversite);
}
