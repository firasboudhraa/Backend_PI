package tn.esprit.backend_pi.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import tn.esprit.backend_pi.entity.Basket;
import tn.esprit.backend_pi.entity.Product;
import tn.esprit.backend_pi.entity.User;
import tn.esprit.backend_pi.repository.BasketRepository;
import tn.esprit.backend_pi.repository.ProductRepository;
import tn.esprit.backend_pi.repository.UserRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class BasketServiceImp implements IBasketService {

    @Autowired
    private BasketRepository basketRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    // Récupère la liste de tous les paniers
    @Override
    public List<Basket> getAllBaskets() {
        return basketRepository.findAll();
    }

    // Récupère un panier par son ID
    @Override
    public Optional<Basket> getBasketById(Long id) {
        return basketRepository.findById(id);
    }

    // Crée et enregistre un nouveau panier
    @Override
    public Basket saveBasket(Basket basket) {
        if (basket.getUtilisateurId() != null) {
            User user = userRepository.findById(basket.getUtilisateurId())
                    .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));
            basket.setUser(user);
        } else {
            throw new RuntimeException("L'utilisateur est obligatoire pour créer un panier.");
        }
        basket.setDateCreation(LocalDate.now());
        return basketRepository.save(basket);
    }

    // Met à jour un panier existant
    @Override
    public Basket updateBasket(Long id, Basket basketDetails) {
        Basket existingBasket = basketRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Panier non trouvé"));
        existingBasket.setStatut(basketDetails.getStatut());
        existingBasket.setModePaiement(basketDetails.getModePaiement());
        existingBasket.setDateModification(LocalDate.now());
        existingBasket.setTotal(calculateTotal(existingBasket));
        return basketRepository.save(existingBasket);
    }

    // Supprime un panier et dissocie ses produits
    @Override
    public void deleteBasket(Long id) {
        Basket basket = basketRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Panier non trouvé"));
        for (Product product : basket.getProducts()) {
            product.getBaskets().remove(basket);
            productRepository.save(product);
        }
        basketRepository.delete(basket);
    }

    // Ajoute un produit à un panier
    @Override
    public Basket addProductToBasket(Long basketId, Long productId) {
        Basket basket = basketRepository.findById(basketId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Panier non trouvé"));
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produit non trouvé"));
        if (!basket.getProducts().contains(product)) {
            basket.getProducts().add(product);
            product.getBaskets().add(basket);
        }
        basket.setDateModification(LocalDate.now());
        basket.setTotal(calculateTotal(basket));
        return basketRepository.save(basket);
    }

    // Supprime un produit d'un panier
    @Override
    public Basket removeProductFromBasket(Long basketId, Long productId) {
        Basket basket = basketRepository.findById(basketId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Panier non trouvé"));
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produit non trouvé"));
        if (!basket.getProducts().contains(product)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Produit non trouvé dans ce panier");
        }
        basket.getProducts().remove(product);
        product.getBaskets().remove(basket);
        basket.setDateModification(LocalDate.now());
        basket.setTotal(calculateTotal(basket));
        return basketRepository.save(basket);
    }

    // Met à jour la quantité d'un produit dans un panier
    @Override
    public Basket updateProductQuantityInBasket(Long basketId, Long productId, int newQuantity) {
        if (newQuantity < 1) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "La quantité doit être au moins 1");
        }
        Basket basket = basketRepository.findById(basketId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Panier non trouvé"));
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produit non trouvé"));
        if (!basket.getProducts().contains(product)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Produit non trouvé dans ce panier");
        }
        int currentOccurrences = (int) basket.getProducts().stream()
                .filter(p -> p.getId_Product().equals(productId))
                .count();
        if (newQuantity > currentOccurrences) {
            for (int i = 0; i < (newQuantity - currentOccurrences); i++) {
                basket.getProducts().add(product);
            }
        } else {
            for (int i = 0; i < (currentOccurrences - newQuantity); i++) {
                basket.getProducts().remove(product);
            }
        }
        basket.setTotal(calculateTotal(basket));
        return basketRepository.save(basket);
    }

    // Vide complètement un panier
    @Override
    public Basket clearBasket(Long basketId) {
        Basket basket = basketRepository.findById(basketId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Panier non trouvé"));
        basket.getProducts().clear();
        basket.setTotal(0.0);
        return basketRepository.save(basket);
    }

    // Calcule le total du panier en fonction des prix des produits
    private double calculateTotal(Basket basket) {
        return basket.getProducts().stream()
                .mapToDouble(Product::getPrix)
                .sum();
    }
}
