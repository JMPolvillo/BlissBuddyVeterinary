package Veterinary.Controller;

import Veterinary.controller.AppointmentsController;
import Veterinary.model.Appointments;
import com.fasterxml.jackson.databind.ObjectMapper;

import Veterinary.model.Patient;
import Veterinary.service.AppointmentsService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



@SpringJUnitConfig
 class AppointmentsControllerTests {

    @Mock
    private AppointmentsService appointmentsService;

    @InjectMocks
    private AppointmentsController appointmentsController;
    private MockMvc mockMvc;
   private Appointments appointments1;
   private Appointments appointments2;
    private ArrayList<Appointments> appointments;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(appointmentsController).build();

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
        appointments2.setTime(LocalTime.of(11,15));
        appointments2.setTypeOfConsultation("Urgent");
        appointments2.setMotif("Labor");
        appointments2.setStatus("Confirmed");

    }
    @Test
    void updateAppointments() throws Exception{
        doNothing().when(appointmentsService).updateAppointments(appointments1, 2);

        ObjectMapper objectMapper = new ObjectMapper();
        String appointmentsJson = objectMapper.writeValueAsString(appointments1);

        mockMvc.perform(put("/appointments/2")
                .contentType(MediaType.APPLICATION_JSON)
                .content(appointmentsJson))
            .andExpect(status().isOk());
    }


}