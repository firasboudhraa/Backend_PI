package tn.esprit.backend_pi.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import tn.esprit.backend_pi.entity.Marketplace;
import tn.esprit.backend_pi.entity.Product;
import tn.esprit.backend_pi.repository.MarketplaceRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MarketplaceServiceImp implements IMarketplaceService {

    @Autowired
    private MarketplaceRepository marketplaceRepository;

    // Récupère la liste de tous les marketplaces
    @Override
    public List<Marketplace> getAllMarketplaces() {
        return marketplaceRepository.findAll();
    }

    // Récupère un marketplace par son ID
    @Override
    public Optional<Marketplace> getMarketplaceById(Long id) {
        return marketplaceRepository.findById(id);
    }

    // Ajoute un nouveau marketplace
    @Override
    public Marketplace saveMarketplace(Marketplace marketplace) {
        return marketplaceRepository.save(marketplace);
    }

    // Met à jour un marketplace existant
    @Override
    public Marketplace updateMarketplace(Long id, Marketplace marketplaceDetails) {
        Marketplace existingMarketplace = marketplaceRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Marketplace non trouvé"));

        existingMarketplace.setName(marketplaceDetails.getName());
        existingMarketplace.setDescription(marketplaceDetails.getDescription());
        existingMarketplace.setStatut(marketplaceDetails.getStatut());

        return marketplaceRepository.save(existingMarketplace);
    }

    // Supprime un marketplace uniquement s'il ne contient aucun produit
    @Override
    public void deleteMarketplace(Long id) {
        Marketplace marketplace = marketplaceRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Marketplace non trouvé"));

        if (!marketplace.getProducts().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Impossible de supprimer : Marketplace contient des produits !");
        }

        marketplaceRepository.deleteById(id);
    }

    // Récupère tous les produits d’un marketplace spécifique
    @Override
    public List<Product> getProductsByMarketplace(Long marketplaceId) {
        Marketplace marketplace = marketplaceRepository.findById(marketplaceId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Marketplace non trouvé"));

        return marketplace.getProducts();
    }

    // Met à jour uniquement le statut d’un marketplace
    @Override
    public Marketplace updateMarketplaceStatus(Long id, String statut) {
        Marketplace marketplace = marketplaceRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Marketplace non trouvé"));

        marketplace.setStatut(statut);

        return marketplaceRepository.save(marketplace);
    }
}

