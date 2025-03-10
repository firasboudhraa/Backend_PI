package tn.esprit.backend_pi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.backend_pi.entity.Appointment;

import java.time.LocalDateTime;

public interface AppointmentRepository extends JpaRepository<Appointment,Long> {

    @Query("SELECT COUNT(a) > 0 FROM Appointment a WHERE a.date = :date")
    boolean isAppointmentTimeTaken(@Param("date") LocalDateTime date);
}
