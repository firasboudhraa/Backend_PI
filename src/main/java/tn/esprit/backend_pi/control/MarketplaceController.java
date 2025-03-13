package tn.esprit.backend_pi.control;

import tn.esprit.backend_pi.entity.Marketplace;
import tn.esprit.backend_pi.entity.Product;
import tn.esprit.backend_pi.service.IMarketplaceService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/marketplaces")
public class MarketplaceController {

    @Autowired
    private IMarketplaceService marketplaceService;

    // Récupérer tous les Marketplaces
    @GetMapping
    public List<Marketplace> getAllMarketplaces() {
        return marketplaceService.getAllMarketplaces();
    }

    // Récupérer un Marketplace par ID
    @GetMapping("/{id}")
    public Optional<Marketplace> getMarketplaceById(@PathVariable Long id) {
        return marketplaceService.getMarketplaceById(id);
    }

    // Ajouter un nouveau Marketplace
    @PostMapping
    public Marketplace createMarketplace(@Valid @RequestBody Marketplace marketplace) {
        return marketplaceService.saveMarketplace(marketplace);
    }

    // Mettre à jour un Marketplace existant
    @PutMapping("/{id}")
    public Marketplace updateMarketplace(@PathVariable Long id, @Valid @RequestBody Marketplace marketplaceDetails) {
        return marketplaceService.updateMarketplace(id, marketplaceDetails);
    }

    // Supprimer un Marketplace, mais seulement s’il ne contient aucun produit
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMarketplace(@PathVariable Long id) {
        marketplaceService.deleteMarketplace(id);
        return ResponseEntity.ok("Marketplace supprimé avec succès.");
    }

    // Récupérer tous les produits d’un Marketplace spécifique
    @GetMapping("/{id}/products")
    public List<Product> getProductsByMarketplace(@PathVariable Long id) {
        return marketplaceService.getProductsByMarketplace(id);
    }

    // Mettre à jour uniquement le statut d’un Marketplace
    @PatchMapping("/{id}/status")
    public ResponseEntity<Marketplace> updateMarketplaceStatus(@PathVariable Long id, @RequestParam String statut) {
        Marketplace updatedMarketplace = marketplaceService.updateMarketplaceStatus(id, statut);
        return ResponseEntity.ok(updatedMarketplace);
    }
}
