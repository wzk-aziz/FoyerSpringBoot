package tn.esprit.tp1spring.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.tp1spring.Entity.Etudiant;

import java.util.Optional;

@Repository
public interface EtudiantRepo extends JpaRepository<Etudiant, Long> {
    Etudiant findByCin(long cin);
}
