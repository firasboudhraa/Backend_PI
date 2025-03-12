package tn.esprit.backend_pi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private RoleEnum name;

    // Default constructor
    public Role() {
    }

    // All arguments constructor
    public Role(Long id, RoleEnum name) {
        this.id = id;
        this.name = name;
    }

    // Getter for id
    public Long getId() {
        return id;
    }

    // Setter for id
    public void setId(Long id) {
        this.id = id;
    }

    // Getter for name
    public RoleEnum getName() {
        return name;
    }

    // Setter for name
    public void setName(RoleEnum name) {
        this.name = name;
    }
}
