package tn.esprit.backend_pi.repository;

import tn.esprit.backend_pi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
