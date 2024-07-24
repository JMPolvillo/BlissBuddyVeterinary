package Veterinary.controller;

import Veterinary.model.Appointments;
import Veterinary.model.Patient;
import Veterinary.service.AppointmentsService;
import Veterinary.service.PatientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringJUnitConfig
public class AppointmentsControllerTests {

    @Mock
    private AppointmentsService appointmentsService;

    @InjectMocks
    private AppointmentsController appointmentsController;

    private MockMvc mockMvc;
    private Appointments appointment1;
    private Appointments appointment2;
    private ArrayList<Appointments> appointmentList;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(appointmentsController).build();

        appointment1 = new Appointments();
        appointment1.setId(1);
        appointment1.setDate(LocalDate.of(2024,10,25));
        appointment1.setTypeOfConsultation("estandar");
        appointment1.setMotif("holi");
        appointment1.setStatus("holi");



    }

    @Test
    public void test_deletePatientsById() throws Exception {
        when(appointmentsService.deleteAppointmentById(1)).thenReturn(true);





    }
}