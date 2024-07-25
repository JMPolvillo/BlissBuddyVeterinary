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

import static com.fasterxml.jackson.databind.cfg.CoercionInputShape.Array;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



@SpringJUnitConfig
public class AppointmentsControllerTests {

    @Mock
    private AppointmentsService appointmentsService;
    private MockMvc mockMvc;
    private Appointments appointmentsBolita;
    private Appointments appointmentsLia;

    @InjectMocks
    private AppointmentsController appointmentsController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(appointmentsController).build();

        Patient patientBolita = new Patient();
        patientBolita.setName("Bolita");

        appointmentsBolita = new Appointments();
        appointmentsBolita.setId(1);
        appointmentsBolita.setPatient(patientBolita);
//       appointmentsBolita.setDate(LocalDate.of(2024,7,31));
        appointmentsBolita.setTime(LocalTime.of(15,0));
        appointmentsBolita.setTypeOfConsultation("General");
        appointmentsBolita.setMotif("Check");
        appointmentsBolita.setStatus("Earring");

        Patient patientLia = new Patient();
        patientLia.setName("lia");

        appointmentsLia = new Appointments();
        appointmentsLia.setId(2);
        appointmentsLia.setPatient(patientLia);
 //       appointmentsLia.setDate(LocalDate.of(2024,5,15));
        appointmentsLia.setTime(LocalTime.of(11,15));
        appointmentsLia.setTypeOfConsultation("Urgent");
        appointmentsLia.setMotif("Labor");
        appointmentsLia.setStatus("Confirmed");



    }
    @Test
    void updateAppointments() throws Exception{
        doNothing().when(appointmentsService).updateAppointments(appointmentsLia, 2);

        ObjectMapper objectMapper = new ObjectMapper();
        String appointmentsJson = objectMapper.writeValueAsString(appointmentsLia);

        mockMvc.perform(put("/appointments/2")
                .contentType(MediaType.APPLICATION_JSON)
                .content(appointmentsJson))
            .andExpect(status().isOk());
    }


}