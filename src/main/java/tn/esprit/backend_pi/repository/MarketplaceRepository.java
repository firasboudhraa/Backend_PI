package tn.esprit.backend_pi.repository;

import tn.esprit.backend_pi.entity.Marketplace;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarketplaceRepository extends JpaRepository<Marketplace, Long> {
}
