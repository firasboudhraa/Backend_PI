package tn.esprit.pi_houssem.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


public class MedicalRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long UUId;
    private Date DateTime;
    private MedicalRecordType type;
    private String description;
    private long veterinarian_id;
    private Date next_due_date;
    @Column(nullable = true)
    private long carnet_id;
    @ElementCollection
    private List<String> attachments = new ArrayList<>();
    /*@ManyToOne
    private Carnet carnet;*/
}
