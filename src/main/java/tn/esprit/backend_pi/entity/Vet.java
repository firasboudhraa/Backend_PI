package tn.esprit.backend_pi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Vet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idAppointment;

    private LocalDateTime date;
    private int durationInMinutes;
    private String notes;

}
