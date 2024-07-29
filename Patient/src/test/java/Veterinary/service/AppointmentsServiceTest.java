package Veterinary.service;

import Veterinary.Repository.AppointmentsRepository;
import Veterinary.model.Appointments;
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

class AppointmentsServiceTest {

    @InjectMocks
    private AppointmentsService appointmentsService;

    private Appointments appointmentLia;
    private Appointments appointmentBolita;
    private ArrayList<Appointments> appointmentList = new ArrayList<>();

    @Mock
    private AppointmentsRepository appointmentsRepository;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);

        appointmentLia = new Appointments();
        appointmentLia.setId(1);
        appointmentLia.setDate(LocalDate.of(2024,10,25));
        appointmentLia.setTime(LocalTime.of(12, 5));
        appointmentLia.setTypeOfConsultation("estandar");
        appointmentLia.setMotif("hola");
        appointmentLia.setStatus("hola");
    }

    @Test
    void createAppointment() {
    }

    @Test
    void updateAppointments() {
    }

    @Test
    void getAllAppointments() {
    }

    @Test
    void getAppointmentById() {
    }

    @Test
    void deleteAppointment() {
    }

    @Test
    void deleteAppointmentByIdTest() {
        int id = 2;
        appointmentsService.deleteAppointmentById(id);
        verify(appointmentsRepository).deleteById(id);

    }
}