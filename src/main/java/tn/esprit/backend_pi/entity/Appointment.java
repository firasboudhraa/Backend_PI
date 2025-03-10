package tn.esprit.backend_pi.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long  idAppointment;

    private LocalDateTime date;
    private int durationInMinutes;
    private String notes;

    @Enumerated(EnumType.STRING)
    private AppointmentStatus status;

    @Column(nullable = false)
    private Long  userId;  // Reference to User

    @Column(nullable = true)
    private Long  petId;  // Reference to Pet

    @Column(nullable = true)
    private Long  generalServiceId; // Reference to General Service

    @Column(nullable = true)
    private Long  vetId; // Reference to Veterinarian (For Vet Consultation)
}
