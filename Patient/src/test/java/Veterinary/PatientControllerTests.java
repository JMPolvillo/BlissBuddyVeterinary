package Veterinary;

import Veterinary.Repository.PatientRepository;
import Veterinary.controller.PatientController;
import Veterinary.model.Patient;
import Veterinary.service.PatientService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringJUnitConfig
public class PatientControllerTests {

	@Mock
	private PatientService patientService;
	private MockMvc mockMvc;
	private Patient patientBolita;
	private String patientJson;

	@InjectMocks
	private PatientController patientController;

	@BeforeEach
	void setUp() throws Exception {
		patientBolita = new Patient();
		patientBolita.setId(1);
		patientBolita.setName("Bolita");
		patientBolita.setAge(4);
		patientBolita.setSex("Hembra");
		patientBolita.setRace("Belier");
		patientBolita.setNumberId("4538");
		patientBolita.setTutorIsName("Maria");
		patientBolita.setTutorIsLastName("Rodriguez");
		patientBolita.setTutorPhone("658986742");

	}

	@Test
	void createTestPatient() throws Exception {
		when(patientService.createPatient(any(Patient.class))).thenReturn(patientBolita);

		mockMvc.perform(post("/patients")
						.contentType(MediaType.APPLICATION_JSON)
						.content(patientJson))
				.andExpect(status().isCreated())
				.andExpect(jsonPath("$.id").value(1))
				.andExpect(jsonPath("$.name").value("Bolita"))
				.andExpect(jsonPath("$.age").value(4))
				.andExpect(jsonPath("$.sex").value("Hembra"))
				.andExpect(jsonPath("$.race").value("Belier"))
				.andExpect(jsonPath("$.numberId").value("4538"))
				.andExpect(jsonPath("$.tutorIsName").value("Maria"))
				.andExpect(jsonPath("$.tutorIsLastName").value("Rodriguez"))
				.andExpect(jsonPath("$.tutorPhone").value("658986742"));
	}
}
