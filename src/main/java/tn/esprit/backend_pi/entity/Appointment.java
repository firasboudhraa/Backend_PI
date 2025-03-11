package tn.esprit.backend_pi.entity;

import jakarta.persistence.*;
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
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idAppointment;

    private LocalDateTime date;
    private int durationInMinutes;
    private String notes;

    @Enumerated(EnumType.STRING)
    private AppointmentStatus status;

    // Relationships
    @ManyToOne
    //@JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
   // @JoinColumn(name = "pet_id")
    private Pet pet;

    @ManyToOne
   // @JoinColumn(name = "general_service_id")
    private GeneralService generalService;

    @ManyToOne
  //  @JoinColumn(name = "vet_id")
    private Vet vet;
}
