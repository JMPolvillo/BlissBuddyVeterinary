package Veterinary;

import Veterinary.controller.PatientController;
import Veterinary.model.Patient;
import Veterinary.service.PatientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringJUnitConfig
class PatientControllerTests {

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
	void updatePatient
}