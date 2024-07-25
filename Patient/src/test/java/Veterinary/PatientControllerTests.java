package Veterinary;

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
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PatientController.class)
public class PatientControllerTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private PatientService patientService;

	private Patient patientBolita;
	private String patientJson;

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

		mockMvc.perform(post("/api/patients")
						.contentType(MediaType.APPLICATION_JSON)
						.content(patientJson))
				.andExpect(status().isOk())
				.andExpect(content().json(patientJson));
	}
}
