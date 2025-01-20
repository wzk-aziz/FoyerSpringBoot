package tn.esprit.tp1spring.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity //via lombok
@Getter //via lombok

@Setter //via lombok
@NoArgsConstructor //constructeur non paramétré via lombok
@AllArgsConstructor //constructeur paramétérer via lombok
@ToString //via lombok
public class Bloc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("idBloc")
    Long idBloc;
    @JsonProperty("nomBloc")
    String nomBloc;
    @JsonProperty("capaciteBloc")
    Long capaciteBloc;
    //one to many m3a foyer ama tetkteb manytoone

    @ManyToOne
    @JsonBackReference
    Foyer foyer;

    //OneToMany M3a el chambre
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bloc")
    @JsonBackReference
    @JsonIgnore
    Set<Chambre> chambres;
}
