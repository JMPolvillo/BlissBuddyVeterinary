package Veterinary.controller;

import Veterinary.model.Patient;
import Veterinary.service.PatientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
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
	private ArrayList<Patient> patientList;

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
	public void test_deletePatientsById() throws Exception {
		when(patientService.deletePatientById(1)).thenReturn(true);

		mockMvc.perform(delete("/patients/1"))
				.andExpect(status().isOk())
				.andExpect(content().string("Patient with id" + 1 + "was deleted"));

		when(patientService.deletePatientById(1)).thenReturn(false);

		mockMvc.perform(delete("/patients/1"))
				.andExpect(status().isOk())
				.andExpect(content().string("Error, we have a problem trying to delete patient with id 1"));
	}

}