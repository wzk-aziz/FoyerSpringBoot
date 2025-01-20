package tn.esprit.tp1spring.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.tp1spring.Entity.Bloc;

import java.util.Optional;

@Repository
public interface BlocRepo extends JpaRepository<Bloc, Long> {


}
