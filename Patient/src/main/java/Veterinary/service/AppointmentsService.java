package Veterinary.service;

import Veterinary.Repository.IAppointmentsRepository;
import Veterinary.model.Appointments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class AppointmentsService {
    @Autowired
    IAppointmentsRepository iAppointmentsRepository;

    public Appointments createAppointment(Appointments appointment) {
        return iAppointmentsRepository.save(appointment);
    }

    public void updateAppointments(Appointments appointments, int id) {
        appointments.setId(id);
        iAppointmentsRepository.save(appointments);
    }


    public List<Appointments> getAllAppointments() {
        try {
            return iAppointmentsRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving appointments", e);
        }
    }

    public Optional<Appointments> getAppointmentById(int id) {
        try {
            return iAppointmentsRepository.findById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving appointment by id", e);
        }
    }

    public void deleteAppointment(Appointments newAppointment) {
        iAppointmentsRepository.delete(newAppointment);
    }

    public boolean deleteAppointmentById(int id) {
        try {
            iAppointmentsRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

}