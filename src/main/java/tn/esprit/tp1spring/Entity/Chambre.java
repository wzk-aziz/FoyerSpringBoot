package tn.esprit.tp1spring.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Chambre {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Long idChambre;
    Long numeroChambre;
    @Enumerated(EnumType.STRING)
    TypeChambre typeChambre;

    @ManyToOne
    @JsonBackReference
    Bloc bloc;

    @OneToMany(cascade = CascadeType.ALL)
    @JsonBackReference
     Set <Reservation> Reservations;

}
