package tn.esprit.backend_pi.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.List;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Product;

    @NotBlank(message = "Le nom du produit est obligatoire")
    @Size(min = 2, max = 100, message = "Le nom doit contenir entre 2 et 100 caractères")
    private String nom;

    @NotBlank(message = "La description ne peut pas être vide")
    @Size(max = 500, message = "La description ne doit pas dépasser 500 caractères")
    private String description;

    @NotNull(message = "Le prix est obligatoire")
    @DecimalMin(value = "0.01", message = "Le prix doit être supérieur à 0")
    private Double prix;

    @NotBlank(message = "L'URL de l'image est obligatoire")
    private String imageUrl;

    @NotNull(message = "Le stock est obligatoire")
    @PositiveOrZero(message = "Le stock doit être positif ou nul")
    private Integer stock;

    @ManyToOne
    @JoinColumn(name = "marketplace_id")
    private Marketplace marketplace;

    @ManyToMany(mappedBy = "products")
    private List<Basket> baskets;

    // Getters et Setters du product

    public Long getId_Product() {
        return id_Product;
    }

    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrix() {
        return prix;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Integer getStock() {
        return stock;
    }

    public Marketplace getMarketplace() {
        return marketplace;
    }

    public List<Basket> getBaskets() {
        return baskets;
    }

    // Setters
    public void setId_Product(Long id_Product) {
        this.id_Product = id_Product;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public void setMarketplace(Marketplace marketplace) {
        this.marketplace = marketplace;
    }

    public void setBaskets(List<Basket> baskets) {
        this.baskets = baskets;
    }

}
