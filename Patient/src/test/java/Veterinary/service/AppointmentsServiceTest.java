package Veterinary.service;

import Veterinary.Repository.AppointmentsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

class AppointmentsServiceTest {

    @InjectMocks
    private AppointmentsService appointmentsService;

    @Mock
    private AppointmentsRepository appointmentsRepository;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
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