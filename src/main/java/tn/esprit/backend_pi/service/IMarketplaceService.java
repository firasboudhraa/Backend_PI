package tn.esprit.backend_pi.service;

import tn.esprit.backend_pi.entity.Marketplace;
import tn.esprit.backend_pi.entity.Product;

import java.util.List;
import java.util.Optional;

public interface IMarketplaceService {

    List<Marketplace> getAllMarketplaces();
    Optional<Marketplace> getMarketplaceById(Long id);
    Marketplace saveMarketplace(Marketplace marketplace);
    Marketplace updateMarketplace(Long id, Marketplace marketplaceDetails);
    void deleteMarketplace(Long id);
    List<Product> getProductsByMarketplace(Long marketplaceId);
    Marketplace updateMarketplaceStatus(Long id, String statut);
}
