package tn.esprit.backend_pi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.backend_pi.entity.PetService;

public interface ServiceRepository extends JpaRepository<PetService,Long> {
}
