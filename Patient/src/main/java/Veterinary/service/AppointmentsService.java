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
    AppointmentsRepository appointmentsRepository;

    public Appointments createAppointment(Appointments appointment) {
        return appointmentsRepository.save(appointment);
    }

public void updateAppointments(Appointments appointments, int id){
    appointments.setId(id);
    AppointmentsRepository.findById(appointments);
    }


    public List<Appointments> getAllAppointments() {
        try {
            return appointmentsRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving appointments", e);
        }
    }

    public Optional<Appointments> getAppointmentById(int id) {
        try {
            return appointmentsRepository.findById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving appointment by id", e);
        }
    }
    public void deleteAppointment (Appointments newAppointment) {
        appointmentsRepository.delete(newAppointment);
    }

    public void deleteAppointmentById(int id){
        appointmentsRepository.deleteById(id);
    }
    }



