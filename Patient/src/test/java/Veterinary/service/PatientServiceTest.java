package Veterinary.service;

import Veterinary.Repository.PatientRepository;
import Veterinary.model.Patient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

class PatientServiceTest {
    @InjectMocks
    private PatientService patientService;

    @Mock
    private PatientRepository patientRepository;

    private Patient patientBolita;
    private Patient patientLia;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

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
    void getAllPatients() {
        List<Patient> patientList = new ArrayList<>();
        patientList.add(patientBolita);
        patientList.add(patientLia);

        when(patientRepository.findAll()).thenReturn(patientList);

        List<Patient> allPatients = patientService.getAllPatients();

        assertNotNull(allPatients);
        assertEquals(2, allPatients.size());
        assertTrue(allPatients.contains(patientBolita));
        assertTrue(allPatients.contains(patientLia));
        verify(patientRepository, times(1)).findAll();
    }

    @Test
    void getPatientById() {
        when(patientRepository.findById(anyInt())).thenReturn(Optional.of(patientBolita));

        Optional<Patient> foundPatient = patientService.getPatientById(1);

        assertTrue(foundPatient.isPresent());
        assertEquals(patientBolita.getId(), foundPatient.get().getId());
        assertEquals(patientBolita.getName(), foundPatient.get().getName());
        verify(patientRepository, times(1)).findById(1);
    }

}