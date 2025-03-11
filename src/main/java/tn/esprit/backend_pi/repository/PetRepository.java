package tn.esprit.pi_houssem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.pi_houssem.entity.Pet;

@Repository
public interface PetRepository extends JpaRepository<Pet,Long> {
}
