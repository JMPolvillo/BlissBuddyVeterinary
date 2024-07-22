package Veterinary.service;

import Veterinary.Repository.AppointmentsRepository;
import Veterinary.model.Appointments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class AppointmentsService {
    @Autowired
    AppointmentsRepository appointmentsRepository;

    public void deleteAppointment (Appointments newAppointment) {
        appointmentsRepository.delete(newAppointment);
    }
    
    //public void deleteAppointmentById(Long id){
        //appointmentsRepository.deleteById(id);
    //}


}
