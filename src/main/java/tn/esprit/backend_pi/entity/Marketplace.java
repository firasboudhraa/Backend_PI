package tn.esprit.backend_pi.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Marketplace {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Marketplace;

    @NotBlank(message = "Le nom de la marketplace est obligatoire")
    @Size(min = 3, max = 100, message = "Le nom doit contenir entre 3 et 100 caractères")
    private String name;

    @NotBlank(message = "La description ne peut pas être vide")
    @Size(max = 500, message = "La description ne doit pas dépasser 500 caractères")
    private String description;
    private LocalDate dateCreation;

    @NotNull(message = "Le statut est obligatoire")
    @Pattern(regexp = "(?i)actif|inactif", message = "Le statut doit être 'actif' ou 'inactif'")
    private String statut;



    @OneToMany(mappedBy = "marketplace", cascade = CascadeType.ALL)
    private List<Product> products;

    // Getters et Setters du Marketplace


    // Getters
    public Long getId_Marketplace() {
        return id_Marketplace;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDateCreation() {
        return dateCreation;
    }

    public String getStatut() {
        return statut;
    }

    public List<Product> getProducts() {
        return products;
    }

    // Setters
    public void setId_Marketplace(Long id_Marketplace) {
        this.id_Marketplace = id_Marketplace;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDateCreation(LocalDate dateCreation) {
        this.dateCreation = dateCreation;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

}