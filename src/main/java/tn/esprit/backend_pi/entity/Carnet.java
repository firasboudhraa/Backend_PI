package tn.esprit.pi_houssem.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
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

public class Carnet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long UUId;
    @JsonProperty

    @Column(nullable = true)
    private Long PetId;
    @JsonProperty
    private String MedicalHistory;
    /*  @JsonProperty
    @OneToOne
     private Pet pet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy="MedicalRecord")
    private Set<MedicalRecord> medicalRecords;*/
}
