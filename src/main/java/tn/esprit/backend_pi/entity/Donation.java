package tn.esprit.backend_pi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Donation {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @JsonProperty
    private long id;
    @JsonProperty
    private float amount;
    @ManyToOne
    @JoinColumn(name = "user_id",nullable = true)
    @JsonProperty
    private User UserId;
    @JsonProperty
    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name = "event_id", nullable = true)
    @JsonProperty
    private Event event;
}
