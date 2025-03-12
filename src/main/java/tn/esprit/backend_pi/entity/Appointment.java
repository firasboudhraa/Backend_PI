package tn.esprit.backend_pi.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @JoinColumn(name = "user_id",nullable = true)
    private User  userId;

    @ManyToOne
    @JoinColumn(name = "petId",nullable = true)
    private Pet  petId;

    @ManyToOne
    @JoinColumn(name= "idService",nullable = true)
    @JsonIgnore
    private PetService  generalServiceId; // Reference to General Service

    @ManyToOne
    @JoinColumn(name= "vet_id",nullable = true)
    private User  vetId; // Reference to Veterinarian (For Vet Consultation)
}
