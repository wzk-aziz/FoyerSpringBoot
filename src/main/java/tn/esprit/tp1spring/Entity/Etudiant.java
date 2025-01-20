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
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    Long idetudiant;
    String nomEt;
    String prenomEt;
    Long cin;
    String ecole;
    Date dateNaissance;

    @ManyToMany(mappedBy = "Etudiants",cascade = CascadeType.ALL)
    @JsonBackReference
    @JsonIgnore
    Set<Reservation> Reservations;
}
