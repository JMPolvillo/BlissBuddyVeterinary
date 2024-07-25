package Veterinary;

import Veterinary.controller.AppointmentsController;
import Veterinary.model.Appointments;
import Veterinary.service.AppointmentsService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;


import static org.mockito.Mockito.doNothing;




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
        appointment1.setTime(LocalTime.of(12, 5));
        appointment1.setTypeOfConsultation("estandar");
        appointment1.setMotif("hola");
        appointment1.setStatus("hola");

    }
    @Test
    void updateAppointment() throws Exception {
        doNothing().when(appointmentsService).updateAppointments(appointment2, 2);






    }


}