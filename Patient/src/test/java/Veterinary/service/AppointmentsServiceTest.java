package Veterinary.service;

import Veterinary.Repository.AppointmentsRepository;
import Veterinary.Repository.IAppointmentsRepository;
import Veterinary.model.Appointments;
import Veterinary.model.Patient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class AppointmentsServiceTest {

    @Mock
    private IAppointmentsRepository iAppointmentsRepository;

    @InjectMocks
    private AppointmentsService appointmentsService;

    private Appointments appointments1;
    private Appointments appointments2;
    private final ArrayList<Appointments> appointmentsList = new ArrayList<>();

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);

        appointments1 = new Appointments();
        appointments1.setId(1);
        appointments1.setDate(LocalDate.of(2024,7,31));
        appointments1.setTime(LocalTime.of(15,0));
        appointments1.setTypeOfConsultation("General");
        appointments1.setMotif("Check");
        appointments1.setStatus("Earring");

        appointments2 = new Appointments();
        appointments2.setId(2);
        appointments2.setDate(LocalDate.of(2024,5,15));
        appointments2.setTypeOfConsultation("Urgent");
        appointments2.setMotif("Labor");
        appointments2.setStatus("Confirmed");
    }



    @Test
    void updateAppointments() {
        when(iAppointmentsRepository.save(any(Appointments.class))).thenReturn(appointments2);

        Appointments appointmentsToUpdate = new Appointments();
        appointmentsToUpdate.setId(2);
        appointmentsToUpdate.setDate(LocalDate.of(2024,10,15));
        appointmentsToUpdate.setMotif("Vaccines");


        appointmentsService.updateAppointments(appointmentsToUpdate, 2);
        assertEquals(2, appointmentsToUpdate.getId());
        verify(iAppointmentsRepository, times(1)).save(appointmentsToUpdate);
    }
    @Test
    void createAppointments(){

        when(iAppointmentsRepository.save(any(Appointments.class))).thenReturn(appointments1);

        Appointments createdAppointment = appointmentsService.createAppointment(appointments1);

        assertEquals(appointments1.getDate(), createdAppointment.getDate());
        assertEquals(appointments1.getTime(), createdAppointment.getTime());
        assertEquals(appointments1.getTypeOfConsultation(), createdAppointment.getTypeOfConsultation());
        assertEquals(appointments1.getMotif(), createdAppointment.getMotif());
        assertEquals(appointments1.getStatus(), createdAppointment.getStatus());
        verify(iAppointmentsRepository, times(1)).save(appointments1);
    }


    @Test
    void deleteAppointmentByIdTest() {
        int id = 2;
        appointmentsService.deleteAppointmentById(id);
        verify(iAppointmentsRepository).deleteById(id);
    }
}