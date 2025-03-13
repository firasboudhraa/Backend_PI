package tn.esprit.backend_pi.service;

import tn.esprit.backend_pi.entity.Product;

import java.util.List;
import java.util.Map;

public interface IProductService {

    List<Product> getAllProducts();
    Product getProductById(Long id);
    Product saveProduct(Product product);
    Product updateProduct(Long productId, Product updatedProduct);
    void deleteProduct(Long id);

    // Ajouter un produit dans un Marketplace
    Product addProductToMarketplace(Long marketplaceId, Product product);

    // Mettre à jour un produit dans un Marketplace spécifique
    Product updateProductInMarketplace(Long marketplaceId, Long productId, Product updatedProduct);

    // Supprimer un produit d'un Marketplace spécifique
    void deleteProductFromMarketplace(Long marketplaceId, Long productId);

    // Décrémenter le stock lors de l'ajout au panier
    void decrementStock(Long productId, int quantity);

    // Rétablir le stock en cas d'annulation
    void restoreStock(Long productId, int quantity);

    // Mettre à jour le stock après validation de la commande
    void confirmOrderStockUpdate(Map<Long, Integer> productQuantities);
}