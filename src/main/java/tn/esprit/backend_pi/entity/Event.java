package tn.esprit.backend_pi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Event {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @JsonProperty
    private long idEvent;
    @JsonProperty
    private String nameEvent;
    @JsonProperty
    private String description;
    @JsonProperty
    private LocalDateTime dateEvent;
    @JsonProperty
    private String location;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    @JsonIgnore
    @JsonProperty
    private List<Donation> donations;
}
