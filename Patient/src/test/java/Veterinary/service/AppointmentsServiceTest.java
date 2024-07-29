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
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

class AppointmentsServiceTest {

    @InjectMocks
    private AppointmentsService appointmentsService;

    @Mock
    private AppointmentsRepository appointmentsRepository;

    private Appointments appointments1;
    private Appointments appointments2;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        appointments1 = new Appointments();
        appointments1.setId(1);
        appointments1.setDate(LocalDate.of(2024, 7, 31));
        appointments1.setTime(LocalTime.of(15, 0));
        appointments1.setTypeOfConsultation("General");
        appointments1.setMotif("Check");
        appointments1.setStatus("Earring");

        appointments2 = new Appointments();
        appointments2.setId(2);
        appointments2.setDate(LocalDate.of(2024, 5, 15));
        appointments2.setTime(LocalTime.of(10, 30)); // Added time to match appointments1 format
        appointments2.setTypeOfConsultation("Urgent");
        appointments2.setMotif("Labor");
        appointments2.setStatus("Confirmed");
    }

    @Test
    void getAllAppointments() {
        List<Appointments> appointmentList = new ArrayList<>();
        appointmentList.add(appointments1);
        appointmentList.add(appointments2);

        when(appointmentsRepository.findAll()).thenReturn(appointmentList);

        List<Appointments> allAppointments = appointmentsService.getAllAppointments();

        assertNotNull(allAppointments);
        assertEquals(2, allAppointments.size());
        assertTrue(allAppointments.contains(appointments1));
        assertTrue(allAppointments.contains(appointments2));
        verify(appointmentsRepository, times(1)).findAll();
    }

    @Test
    void getAppointmentById() {
        when(appointmentsRepository.findById(anyInt())).thenReturn(Optional.of(appointments1));

        Optional<Appointments> foundAppointment = appointmentsService.getAppointmentById(1);

        assertTrue(foundAppointment.isPresent());
        assertEquals(appointments1.getId(), foundAppointment.get().getId());
        assertEquals(appointments1.getDate(), foundAppointment.get().getDate());
        verify(appointmentsRepository, times(1)).findById(1);
    }

}