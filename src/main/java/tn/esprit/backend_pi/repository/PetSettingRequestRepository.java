package tn.esprit.backend_pi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.backend_pi.entity.PetSettingRequest;

@Repository
public interface PetSettingRequestRepository extends JpaRepository<PetSettingRequest,Long> {
}
