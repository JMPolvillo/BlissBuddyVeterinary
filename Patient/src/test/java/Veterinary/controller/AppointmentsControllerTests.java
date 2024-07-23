package Veterinary.controller;

import Veterinary.model.Appointments;
import Veterinary.model.Patient;
import Veterinary.service.AppointmentsService;
import Veterinary.service.PatientService;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}