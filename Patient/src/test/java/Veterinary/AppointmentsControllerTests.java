package Veterinary;

import Veterinary.controller.AppointmentsController;
import Veterinary.model.Appointments;
import Veterinary.model.Patient;
import Veterinary.service.AppointmentsService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AppointmentsController.class)
public class AppointmentsControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AppointmentsService appointmentsService;

    private ObjectMapper objectMapper = new ObjectMapper();



    private Appointments appointment;
    private String appointmentJson;

    @BeforeEach
    void setUp() throws Exception {
        appointment = new Appointments();
        appointment.setId(1);
        appointment.setTime(LocalTime.of(10, 5));
        appointment.setDate(LocalDate.of(2024, 7, 8));
        appointment.setTypeOfConsultation("Revision");
        appointment.setMotif("Pulgas");
        appointment.setState("Pasada");

        appointmentJson = objectMapper.writeValueAsString(appointment);
    }

    @Test
    void createTestAppointments() throws Exception {
        when(appointmentsService.createAppointment(any(Appointments.class))).thenReturn(appointment);

        mockMvc.perform(post("/appointments")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(appointmentJson))
                .andExpect(status().isOk())
                .andExpect(content().json(appointmentJson));
    }
}
