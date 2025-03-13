package tn.esprit.backend_pi.control;


import tn.esprit.backend_pi.entity.Product;
import tn.esprit.backend_pi.service.IProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private IProductService productService;

    // Récupérer tous les produits
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    // Récupérer un produit par son ID
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }

    // Ajouter un produit avec validation
    @PostMapping
    public ResponseEntity<Product> createProduct(@Valid @RequestBody Product product) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.saveProduct(product));
    }

    // Mettre à jour un produit existant
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @Valid @RequestBody Product productDetails) {
        return ResponseEntity.ok(productService.updateProduct(id, productDetails));
    }

    // Supprimer un produit par son ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok("Produit supprimé avec succès !");
    }

    // Ajouter un produit dans un Marketplace
    @PostMapping("/add/{marketplaceId}")
    public ResponseEntity<Product> addProductToMarketplace(@Valid @PathVariable Long marketplaceId, @RequestBody Product product) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.addProductToMarketplace(marketplaceId, product));
    }

    // Mettre à jour un produit dans un Marketplace
    @PutMapping("/update/{marketplaceId}/{productId}")
    public ResponseEntity<Product> updateProductInMarketplace(@PathVariable Long marketplaceId, @PathVariable Long productId, @Valid @RequestBody Product productDetails) {
        return ResponseEntity.ok(productService.updateProductInMarketplace(marketplaceId, productId, productDetails));
    }

    // Supprimer un produit d'un Marketplace
    @DeleteMapping("/marketplace/{marketplaceId}/product/{productId}")
    public ResponseEntity<String> deleteProductFromMarketplace(@PathVariable Long marketplaceId, @PathVariable Long productId) {
        productService.deleteProductFromMarketplace(marketplaceId, productId);
        return ResponseEntity.ok("Produit supprimé du marketplace avec succès !");
    }

    // **************************** Maintenance du stock **********************************

    // Décrémenter le stock lors de l'ajout au panier
    @PostMapping("/{productId}/decrement-stock/{quantity}")
    public ResponseEntity<String> decrementStock(@PathVariable Long productId, @PathVariable int quantity) {
        productService.decrementStock(productId, quantity);
        return ResponseEntity.ok("Stock mis à jour !");
    }

    // Restaurer le stock si la commande est annulée
    @PostMapping("/{productId}/restore-stock/{quantity}")
    public ResponseEntity<String> restoreStock(@PathVariable Long productId, @PathVariable int quantity) {
        productService.restoreStock(productId, quantity);
        return ResponseEntity.ok("Stock restauré !");
    }

    // Mettre à jour le stock après validation d'une commande
    @PostMapping("/confirm-order")
    public ResponseEntity<String> confirmOrderStockUpdate(@RequestBody Map<Long, Integer> productQuantities) {
        productService.confirmOrderStockUpdate(productQuantities);
        return ResponseEntity.ok("Stock mis à jour après validation de la commande !");
    }
}
