package tn.esprit.tp1spring.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    String idReservation;

    Date anneeUniversitaire;
    Boolean estValide;


    @ManyToMany(cascade = CascadeType.ALL)
    @JsonBackReference
   Set<Etudiant> Etudiants;
    @ManyToOne
    @JsonIgnore

    private Chambre chambre;


}
