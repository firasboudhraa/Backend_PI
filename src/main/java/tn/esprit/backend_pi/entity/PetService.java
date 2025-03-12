package tn.esprit.backend_pi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.persistence.GenerationType;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class PetService {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idService;

    private String name;
    private String description;
    private Float price;
    private int durationInMinutes;
    private String address;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<LocalDateTime> availableSlots;

    @Column(nullable = false)
    private Long providerId;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalServiceId")
    private List<Appointment> appointments;
}
