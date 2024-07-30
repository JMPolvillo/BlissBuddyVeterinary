package Veterinary.controller;

import Veterinary.controller.AppointmentsController;
import Veterinary.model.Appointments;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import Veterinary.service.AppointmentsService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

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
        appointments1.setDate(LocalDate.of(2024, 7, 31));
        appointments1.setTypeOfConsultation("General");
        appointments1.setMotif("Check");
        appointments1.setStatus("Pending");

        appointments2 = new Appointments();
        appointments2.setId(2);
        appointments2.setDate(LocalDate.of(2024, 5, 15));
        appointments2.setTypeOfConsultation("Urgent");
        appointments2.setMotif("Labor");
        appointments2.setStatus("Confirmed");
    }

    @Test
    void updateAppointments() throws Exception {
        doNothing().when(appointmentsService).updateAppointments(appointments2, 2);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        String appointmentsJson = objectMapper.writeValueAsString(appointments2);

        mockMvc.perform(put("/appointments/2")
                .contentType(MediaType.APPLICATION_JSON)
                .content(appointmentsJson))
            .andExpect(status().isOk());
    }

    @Test
    void getAppointmentsById() throws Exception {
        when(appointmentsService.getAppointmentById(2)).thenReturn(Optional.of(appointments2));

        mockMvc.perform(get("/appointments/2")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(2))
                .andExpect(jsonPath("$.date").value("15-05-2024"))
                .andExpect(jsonPath("$.time").value("10:00"))
                .andExpect(jsonPath("$.typeOfConsultation").value("Urgent"))
                .andExpect(jsonPath("$.motif").value("Labor"))
                .andExpect(jsonPath("$.status").value("Confirmed"));
    }

    @Test
    void createAppointments() throws Exception {

        when(appointmentsService.createAppointment(any(Appointments.class))).thenReturn(appointments1);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        String appointmentsJson = objectMapper.writeValueAsString(appointments1);

        mockMvc.perform(post("/appointments")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(appointmentsJson))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.date").value("31-07-2024"))
                .andExpect(jsonPath("$.time").value("15:00"))
                .andExpect(jsonPath("$.typeOfConsultation").value("General"))
                .andExpect(jsonPath("$.motif").value("Check"))
                .andExpect(jsonPath("$.status").value("Pending"));
    }

}