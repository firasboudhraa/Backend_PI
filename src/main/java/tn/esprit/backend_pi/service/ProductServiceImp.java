package tn.esprit.backend_pi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import tn.esprit.backend_pi.entity.Marketplace;
import tn.esprit.backend_pi.entity.Product;
import tn.esprit.backend_pi.repository.MarketplaceRepository;
import tn.esprit.backend_pi.repository.ProductRepository;

import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImp implements IProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private MarketplaceRepository marketplaceRepository;

    // Récupérer tous les produits
    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Récupérer un produit par son ID
    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produit non trouvé !"));
    }

    // Ajouter un produit avec validation
    @Override
    public Product saveProduct(Product product) {
        if (product.getPrix() < 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Le prix ne peut pas être négatif !");
        }
        if (product.getStock() < 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Le stock ne peut pas être négatif !");
        }
        return productRepository.save(product);
    }

    // Mettre à jour un produit existant
    @Override
    public Product updateProduct(Long productId, Product updatedProduct) {
        Product existingProduct = productRepository.findById(productId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produit non trouvé !"));

        if (updatedProduct.getNom() != null) existingProduct.setNom(updatedProduct.getNom());
        if (updatedProduct.getDescription() != null) existingProduct.setDescription(updatedProduct.getDescription());
        if (updatedProduct.getPrix() != null && updatedProduct.getPrix() >= 0) {
            existingProduct.setPrix(updatedProduct.getPrix());
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Le prix ne peut pas être négatif !");
        }
        if (updatedProduct.getStock() != null && updatedProduct.getStock() >= 0) {
            existingProduct.setStock(updatedProduct.getStock());
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Le stock ne peut pas être négatif !");
        }

        return productRepository.save(existingProduct);
    }

    // Supprimer un produit par son ID
    @Override
    public void deleteProduct(Long id) {
        if (!productRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Produit non trouvé !");
        }
        productRepository.deleteById(id);
    }

    // Ajouter un produit dans un Marketplace
    @Override
    public Product addProductToMarketplace(Long marketplaceId, Product product) {
        Marketplace marketplace = marketplaceRepository.findById(marketplaceId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Marketplace non trouvé !"));

        if (product.getPrix() < 0 || product.getStock() < 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Le prix et le stock doivent être positifs !");
        }

        product.setMarketplace(marketplace);
        return productRepository.save(product);
    }

    // Mettre à jour un produit dans un Marketplace spécifique
    @Override
    public Product updateProductInMarketplace(Long marketplaceId, Long productId, Product updatedProduct) {
        Marketplace marketplace = marketplaceRepository.findById(marketplaceId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Marketplace non trouvé !"));

        Product existingProduct = productRepository.findById(productId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produit non trouvé !"));

        if (!existingProduct.getMarketplace().getId_Marketplace().equals(marketplaceId)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Le produit ne correspond pas à ce marketplace !");
        }

        if (updatedProduct.getNom() != null) existingProduct.setNom(updatedProduct.getNom());
        if (updatedProduct.getDescription() != null) existingProduct.setDescription(updatedProduct.getDescription());
        if (updatedProduct.getPrix() != null && updatedProduct.getPrix() >= 0) {
            existingProduct.setPrix(updatedProduct.getPrix());
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Le prix ne peut pas être négatif !");
        }
        if (updatedProduct.getStock() != null && updatedProduct.getStock() >= 0) {
            existingProduct.setStock(updatedProduct.getStock());
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Le stock ne peut pas être négatif !");
        }

        return productRepository.save(existingProduct);
    }

    // Supprimer un produit d'un Marketplace spécifique
    @Override
    public void deleteProductFromMarketplace(Long marketplaceId, Long productId) {
        Marketplace marketplace = marketplaceRepository.findById(marketplaceId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Marketplace non trouvé !"));

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produit non trouvé !"));

        if (!product.getMarketplace().getId_Marketplace().equals(marketplaceId)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Le produit ne correspond pas à ce marketplace !");
        }

        productRepository.delete(product);
    }

    // Décrémenter le stock lors de l'ajout au panier
    @Override
    public void decrementStock(Long productId, int quantity) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produit non trouvé !"));

        if (product.getStock() < quantity) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Stock insuffisant !");
        }

        product.setStock(product.getStock() - quantity);
        productRepository.save(product);
    }

    // Rétablir le stock en cas d'annulation
    @Override
    public void restoreStock(Long productId, int quantity) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produit non trouvé !"));

        product.setStock(product.getStock() + quantity);
        productRepository.save(product);
    }

    // Mettre à jour le stock après validation de la commande
    @Override
    public void confirmOrderStockUpdate(Map<Long, Integer> productQuantities) {
        for (Map.Entry<Long, Integer> entry : productQuantities.entrySet()) {
            decrementStock(entry.getKey(), entry.getValue());
        }
    }
}