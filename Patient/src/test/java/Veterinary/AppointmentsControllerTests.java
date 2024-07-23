package Veterinary;

import Veterinary.controller.AppointmentsController;
import Veterinary.model.Appointments;
import Veterinary.model.Patient;
import Veterinary.service.AppointmentsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringJUnitConfig
public class AppointmentsControllerTests {

    @Mock
    private AppointmentsService appointmentsService;
    private MockMvc mockMvc;
    private Appointments appointments1;
    private Appointments appointments2;

    @InjectMocks
    private AppointmentsController appointmentsController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(appointmentsController).build();

        appointments1 = new Appointments();
        appointments1.setId(1);
        appointments1.setPatient("bolita");
        appointments1.setDateTime();
        appointments1.setTypeOfConsultation();
        appointments1.setMotif();
        appointments1.setStatus();

        appointments2 = new Appointments();
        appointments2.setId(2);
        appointments2.setPatient("Lia");
        appointments2.setMotif();


    }
}