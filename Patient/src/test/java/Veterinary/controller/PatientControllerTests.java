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
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


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
		patientBolita.setPhoto("photo-content".getBytes());

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
		patientLia.setPhoto("photo-content".getBytes());
	}

	@Test
	void updatePatient() throws Exception {
		doNothing().when(patientService).updatePatient(any(Patient.class), any(Integer.class));

		ObjectMapper objectMapper = new ObjectMapper();
		String patientJson = objectMapper.writeValueAsString(patientLia);

		mockMvc.perform(put("/patient/2")
						.contentType(MediaType.APPLICATION_JSON)
						.content(patientJson))
				.andExpect(status().isOk());
	}

	@Test
	void createTestPatient() throws Exception {
		when(patientService.createPatient(any(Patient.class))).thenReturn(patientBolita);

		ObjectMapper objectMapper = new ObjectMapper();
		String patientJson = objectMapper.writeValueAsString(patientBolita);

		mockMvc.perform(post("/patient")
						.contentType(MediaType.APPLICATION_JSON)
						.content(patientJson))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.id").value(1))
				.andExpect(jsonPath("$.name").value("Bolita"))
				.andExpect(jsonPath("$.age").value(4))
				.andExpect(jsonPath("$.sex").value("Male"))
				.andExpect(jsonPath("$.race").value("Belier"))
				.andExpect(jsonPath("$.numberId").value("4538"))
				.andExpect(jsonPath("$.tutorIsName").value("Isabé"))
				.andExpect(jsonPath("$.tutorIsLastName").value("Rodriguez"))
				.andExpect(jsonPath("$.tutorPhone").value("658986742"));
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