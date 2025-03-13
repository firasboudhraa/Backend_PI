package tn.esprit.backend_pi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_User ;

    private String username;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Basket> baskets;
}

