package tn.esprit.pi_houssem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.pi_houssem.entity.Carnet;

@Repository
public interface CarnetRepository extends JpaRepository<Carnet, Long> {

}
