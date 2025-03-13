package tn.esprit.backend_pi.control;


import tn.esprit.backend_pi.entity.Basket;
import tn.esprit.backend_pi.service.IBasketService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/baskets")
@RequiredArgsConstructor
public class BasketController {

    @Autowired
    private IBasketService basketService;

    // Récupérer tous les paniers
    @GetMapping
    public ResponseEntity<List<Basket>> getAllBaskets() {
        List<Basket> baskets = basketService.getAllBaskets();
        return ResponseEntity.ok(baskets);
    }

    // Récupérer un panier par ID
    @GetMapping("/{id}")
    public ResponseEntity<Basket> getBasketById(@PathVariable Long id) {
        return basketService.getBasketById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Créer un panier
    @PostMapping
    public ResponseEntity<Basket> createBasket(@Valid @RequestBody Basket basket) {
        Basket savedBasket = basketService.saveBasket(basket);
        return ResponseEntity.ok(savedBasket);
    }

    // Mettre à jour un panier
    @PutMapping("/{id}")
    public ResponseEntity<Basket> updateBasket(@PathVariable Long id, @Valid @RequestBody Basket basketDetails) {
        try {
            Basket updatedBasket = basketService.updateBasket(id, basketDetails);
            return ResponseEntity.ok(updatedBasket);
        } catch (ResponseStatusException e) {
            return ResponseEntity.status(e.getStatusCode()).build();
        }
    }

    // Supprimer un panier
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBasket(@PathVariable Long id) {
        try {
            basketService.deleteBasket(id);
            return ResponseEntity.noContent().build();
        } catch (ResponseStatusException e) {
            return ResponseEntity.status(e.getStatusCode()).build();
        }
    }

    // Ajouter un produit à un panier
    @PostMapping("/{basketId}/products/{productId}")
    public ResponseEntity<Basket> addProductToBasket(@PathVariable Long basketId, @PathVariable Long productId) {
        try {
            Basket updatedBasket = basketService.addProductToBasket(basketId, productId);
            return ResponseEntity.ok(updatedBasket);
        } catch (ResponseStatusException e) {
            return ResponseEntity.status(e.getStatusCode()).build();
        }
    }

    // Endpoint pour mettre à jour la quantité d'un produit dans un panier
    @PutMapping("/{basketId}/products/{productId}/quantity/{newQuantity}")
    public ResponseEntity<Basket> updateProductQuantityInBasket(@PathVariable Long basketId, @PathVariable Long productId, @PathVariable int newQuantity) {
        try {
            return ResponseEntity.ok(basketService.updateProductQuantityInBasket(basketId, productId, newQuantity));
        } catch (ResponseStatusException e) {
            return ResponseEntity.status(e.getStatusCode()).build();
        }
    }

    // Retirer un produit d'un panier
    @DeleteMapping("/{basketId}/products/{productId}")
    public ResponseEntity<Basket> removeProductFromBasket(@PathVariable Long basketId, @PathVariable Long productId) {
        try {
            Basket updatedBasket = basketService.removeProductFromBasket(basketId, productId);
            return ResponseEntity.ok(updatedBasket);
        } catch (ResponseStatusException e) {
            return ResponseEntity.status(e.getStatusCode()).build();
        }
    }

    @DeleteMapping("/{basketId}/clear")
    public ResponseEntity<Basket> clearBasket(@PathVariable Long basketId) {
        try {
            return ResponseEntity.ok(basketService.clearBasket(basketId));
        } catch (ResponseStatusException e) {
            return ResponseEntity.status(e.getStatusCode()).build();
        }
    }



}

