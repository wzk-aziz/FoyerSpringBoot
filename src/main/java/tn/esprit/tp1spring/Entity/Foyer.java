package tn.esprit.tp1spring.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Foyer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("idFoyer")
    Long idFoyer;
    @JsonProperty("nomFoyer")
    String nomFoyer;
    @JsonProperty("capaciteFoyer")
    Long capacitfoyer;
    @JsonIgnore

    //les relation
    //one to one M3a el uni
    @OneToOne (mappedBy = "foyer")
    @JsonBackReference
    private Universite universite;
    //OneToMany M3a el bloc
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "foyer")
    @JsonBackReference
    @JsonIgnore
    Set<Bloc> blocs;
}
