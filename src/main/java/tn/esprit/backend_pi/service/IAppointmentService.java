package tn.esprit.backend_pi.service;

import tn.esprit.backend_pi.entity.Appointment;

import java.util.List;

public interface IAppointmentService {

    List<Appointment> getAllAppointments();
    Appointment getAppointmentById(Long id);
    Appointment createAppointment(Appointment appointment);
    Appointment updateAppointment(Appointment appointment);
    void cancelAppointment(Long id);
}
