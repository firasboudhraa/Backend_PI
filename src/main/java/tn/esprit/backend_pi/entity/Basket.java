package tn.esprit.backend_pi.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.util.List;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Basket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Basket;

    @NotNull(message = "L'ID de l'utilisateur est obligatoire")
    private Long utilisateurId;
    private LocalDate dateCreation;

    @NotNull(message = "Le statut est obligatoire")
    @Pattern(regexp = "en cours|validé|annulé", message = "Le statut doit être 'en cours', 'validé' ou 'annulé'")
    private String statut; // en cours, validé, annulé

    @NotNull(message = "Le total est obligatoire")
    @DecimalMin(value = "0.0", inclusive = false, message = "Le total doit être supérieur à 0")
    private Double total;

    @NotBlank(message = "Le mode de paiement est obligatoire")
    @Pattern(regexp = "carte|PayPal|autre", message = "Le mode de paiement doit être 'carte', 'PayPal' ou 'autre'")
    private String modePaiement; // carte, PayPal, etc.
    private LocalDate dateValidation;
    private LocalDate dateModification;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany
    @JoinTable(
            name = "basket_product",
            joinColumns = @JoinColumn(name = "basket_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> products;

    // Getters et Setters du product

    // Getters
    public Long getId_Basket() {
        return id_Basket;
    }

    public Long getUtilisateurId() {
        return utilisateurId;
    }

    public LocalDate getDateCreation() {
        return dateCreation;
    }

    public String getStatut() {
        return statut;
    }

    public Double getTotal() {
        return total;
    }

    public String getModePaiement() {
        return modePaiement;
    }

    public LocalDate getDateValidation() {
        return dateValidation;
    }

    public LocalDate getDateModification() {
        return dateModification;
    }

    public User getUser() {
        return user;
    }

    public List<Product> getProducts() {
        return products;
    }

    // Setters
    public void setId_Basket(Long id_Basket) {
        this.id_Basket = id_Basket;
    }

    public void setUtilisateurId(Long utilisateurId) {
        this.utilisateurId = utilisateurId;
    }

    public void setDateCreation(LocalDate dateCreation) {
        this.dateCreation = dateCreation;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public void setModePaiement(String modePaiement) {
        this.modePaiement = modePaiement;
    }

    public void setDateValidation(LocalDate dateValidation) {
        this.dateValidation = dateValidation;
    }

    public void setDateModification(LocalDate dateModification) {
        this.dateModification = dateModification;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
