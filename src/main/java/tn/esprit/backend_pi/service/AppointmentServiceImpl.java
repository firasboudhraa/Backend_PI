package tn.esprit.backend_pi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.backend_pi.entity.Appointment;
import tn.esprit.backend_pi.repository.AppointmentRepository;

import java.util.List;

@Service
public class AppointmentServiceImpl implements IAppointmentService{

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Override
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    @Override
    public Appointment getAppointmentById(Long id) {
        return appointmentRepository.findById(id).get();
    }

    @Override
    public Appointment createAppointment(Appointment appointment) {
        // Step 1: Check if the requested appointment date is already taken for the same service
        boolean isTimeTakenForService = appointmentRepository.existsByServiceAndDate(appointment.getGeneralServiceId(), appointment.getDate());

        // If the date is already taken for this service, return null or throw an exception
        if (isTimeTakenForService) {
            return null;  // Date already taken for this service, appointment not created
        }

        // Step 2: Create the appointment since the date is available for the service
        return appointmentRepository.save(appointment);
    }

    @Override
    public Appointment updateAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    @Override
    public void cancelAppointment(Long id) {
        appointmentRepository.deleteById(id);
    }

}
