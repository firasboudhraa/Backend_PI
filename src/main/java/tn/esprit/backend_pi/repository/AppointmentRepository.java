package tn.esprit.backend_pi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.backend_pi.entity.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment,Long> {
}
