package tn.esprit.backend_pi.repository;

import tn.esprit.backend_pi.entity.Basket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasketRepository extends JpaRepository<Basket, Long> {
}
