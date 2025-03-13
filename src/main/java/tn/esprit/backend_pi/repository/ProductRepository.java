package tn.esprit.backend_pi.repository;

import tn.esprit.backend_pi.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
}

