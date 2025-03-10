package tn.esprit.backend_pi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.backend_pi.entity.Pet;

@Repository
public interface PetRepository extends JpaRepository<Pet,Long> {
}
