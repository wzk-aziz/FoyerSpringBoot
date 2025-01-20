package tn.esprit.tp1spring.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.tp1spring.Entity.Foyer;

import java.util.List;

@Repository
public interface FoyerRepo extends JpaRepository<Foyer, Long> {


}
