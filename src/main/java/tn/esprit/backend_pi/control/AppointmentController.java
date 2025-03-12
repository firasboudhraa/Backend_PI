package tn.esprit.backend_pi.control;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.backend_pi.entity.Appointment;
import tn.esprit.backend_pi.service.IAppointmentService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/appointments")
public class AppointmentController {

    @Autowired
    private IAppointmentService appointmentService;

    // GET: Retrieve all Appointments
    @GetMapping("/retrieve-all-appointments")
    public List<Appointment> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }

    // GET: Retrieve an Appointment by ID
    @GetMapping("/retrieve-appointment/{id}")
    public Appointment getAppointmentById(@PathVariable("id") Long id) {
        return appointmentService.getAppointmentById(id);
    }

    // POST: Add a new Appointment
    @PostMapping("/add-appointment")
    public Appointment addAppointment(@RequestBody Appointment appointmentRequest) {
        return appointmentService.createAppointment(appointmentRequest);
    }

    // DELETE: Remove an Appointment by ID
    @DeleteMapping("/remove-appointment/{id}")
    public void removeAppointment(@PathVariable("id") Long id) {
        appointmentService.cancelAppointment(id);
    }

    // PUT: Modify an existing Appointment
    @PutMapping("/modify-appointment")
    public Appointment modifyAppointment(@RequestBody Appointment appointment) {
        return appointmentService.updateAppointment(appointment);
    }
}
