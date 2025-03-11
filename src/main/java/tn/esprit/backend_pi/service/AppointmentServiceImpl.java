package tn.esprit.backend_pi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.backend_pi.entity.Appointment;
import tn.esprit.backend_pi.entity.PetService;
import tn.esprit.backend_pi.repository.AppointmentRepository;
import tn.esprit.backend_pi.repository.ServiceRepository;

import java.util.List;

@Service
public class AppointmentServiceImpl implements IAppointmentService{

    @Autowired
    private AppointmentRepository appointmentRepository;
    @Autowired
    private ServiceRepository serviceRepository;

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
        PetService petService = serviceRepository.findById(appointment.getGeneralServiceId().getIdService()).get();
        // Check if the requested slot is available for the selected service
        if (!petService.getAvailableSlots().contains(appointment.getDate())) {
            return null;
        }
        // Remove the booked slot from the available slots list
        petService.getAvailableSlots().remove(appointment.getDate());
        serviceRepository.save(petService);

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
