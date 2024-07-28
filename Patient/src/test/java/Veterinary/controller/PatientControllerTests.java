package Veterinary.controller;

import Veterinary.controller.PatientController;
import Veterinary.model.Patient;
import Veterinary.service.PatientService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringJUnitConfig
public class PatientControllerTests {

	@Mock
	private PatientService patientService;

	@InjectMocks
	private PatientController patientController;

	private MockMvc mockMvc;
	private Patient patientBolita;
	private Patient patientLia;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(patientController).build();

		patientBolita = new Patient();
		patientBolita.setId(1);
		patientBolita.setName("Bolita");
		patientBolita.setAge(4);
		patientBolita.setSex("Male");
		patientBolita.setRace("Belier");
		patientBolita.setNumberId(4538);
		patientBolita.setTutorIsName("Isabé");
		patientBolita.setTutorIsLastName("Rodriguez");
		patientBolita.setTutorPhone(658986742);

		patientLia = new Patient();
		patientLia.setId(2);
		patientLia.setName("Lia");
		patientLia.setAge(5);
		patientLia.setSex("Female");
		patientLia.setRace("Water dog");
		patientLia.setNumberId(4539);
		patientLia.setTutorIsName("Kratos");
		patientLia.setTutorIsLastName("Onubense");
		patientLia.setTutorPhone(615895746);
	}

	@Test
	public void test_getPatientById() throws Exception {
		when(patientService.getPatientById(2)).thenReturn(Optional.of(patientLia));

		ObjectMapper objectMapper = new ObjectMapper();
		String patientJson = objectMapper.writeValueAsString(patientLia);

		mockMvc.perform(MockMvcRequestBuilders.get("/patients/2"))
				.andExpect(status().isOk())
				.andExpect(content().json(patientJson));

		when(patientService.getPatientById(1)).thenReturn(Optional.of(patientBolita));

		patientJson = objectMapper.writeValueAsString(patientBolita);

		mockMvc.perform(MockMvcRequestBuilders.get("/patients/1"))
				.andExpect(status().isOk())
				.andExpect(content().json(patientJson));
	}
}
