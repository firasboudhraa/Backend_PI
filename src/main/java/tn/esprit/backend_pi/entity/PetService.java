package tn.esprit.backend_pi.entity;

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

    @ElementCollection
    private List<LocalDateTime> availableSlots;

    @Column(nullable = false)
    private Long providerId;
}
