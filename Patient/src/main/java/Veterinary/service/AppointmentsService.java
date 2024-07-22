package Veterinary.service;

import Veterinary.Repository.AppointmentsRepository;
import Veterinary.model.Appointments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentsService {

    @Autowired
    private AppointmentsRepository appointmentsRepository;

    public List<Appointments> getAllAppointments() {
        try {
            return appointmentsRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving appointments", e);
        }
    }

    public Optional<Appointments> getAppointmentById(Long id) {
        try {
            return appointmentsRepository.findById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving appointment by id", e);
        }
    }
}
