package tn.esprit.backend_pi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.backend_pi.entity.Donation;

@Repository
public interface DonationRepository extends JpaRepository <Donation,Long> {
}
