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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  idAppointment;

    private LocalDateTime date;
    private int durationInMinutes;
    private String notes;

    @Enumerated(EnumType.STRING)
    private AppointmentStatus status;

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private User  userId;

    @ManyToOne
    @JoinColumn(name = "id",nullable = false)
    private Pet  petId;

    @ManyToOne
    @JoinColumn(name= "idService",nullable = true)
    private PetService  generalServiceId; // Reference to General Service

    @ManyToOne
    @JoinColumn(name= "vet_id",nullable = true)
    private User  vetId; // Reference to Veterinarian (For Vet Consultation)
}
