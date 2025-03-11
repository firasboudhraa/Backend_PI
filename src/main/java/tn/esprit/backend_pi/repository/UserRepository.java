package tn.esprit.backend_pi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.backend_pi.entity.User;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
}
