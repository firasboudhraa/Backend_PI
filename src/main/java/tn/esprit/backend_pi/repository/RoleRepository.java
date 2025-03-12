package tn.esprit.backend_pi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.backend_pi.entity.Role;

public interface RoleRepository  extends JpaRepository<Role, Long> {
}
