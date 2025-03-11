package tn.esprit.backend_pi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tn.esprit.backend_pi.entity.PetService;

import java.time.LocalDateTime;

public interface ServiceRepository extends JpaRepository<PetService,Long> {
    // Custom query to find a PetService by its id and check if the available slot exists
    @Query("SELECT p FROM PetService p WHERE p.idService = :serviceId AND :slot member of p.availableSlots")
    PetService findPetServiceWithSlotAvailable(Long serviceId, LocalDateTime slot);
}
