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

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Universite implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @JsonProperty("iduniversite")
    Long iduniversite;
    @JsonProperty("nomuniversite")
    String nomuniversite;
    @JsonProperty("adresse")
    String adresse;

@OneToOne
@JsonBackReference
@JsonProperty("foyer")
@JsonIgnore

    private Foyer foyer;
}
