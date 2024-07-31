package com.blissbuddyveterinary.services;

import com.blissbuddyveterinary.repositories.IPatientRepository;
import com.blissbuddyveterinary.models.Appointments;
import com.blissbuddyveterinary.models.Patient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
public class PatientServiceTests {

    @Mock
    private IPatientRepository iPatientRepository;

    @InjectMocks
    private PatientService patientService;

    private Patient patientBolita;
    private Patient patientLia;
    private final ArrayList<Patient> patientList = new ArrayList<>();

    @BeforeEach
    public void SetUp(){
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
    void updatePatient() {
        when(iPatientRepository.save(any(Patient.class))).thenReturn(patientBolita);

        Patient patientToUpdate = new Patient();
        patientToUpdate.setNumberId(1);
        patientToUpdate.setName("UpdatedBolita");
        patientToUpdate.setTutorIsName("UpdatedIsabé");

        MockMultipartFile photoByte = new MockMultipartFile("photo", "photo.jpg", "image/jpeg", "updated-photo-content".getBytes());

        patientService.updatePatient(patientToUpdate, 1);

        assertEquals(1, patientToUpdate.getId());
        verify(iPatientRepository, times(1)).save(patientToUpdate);
    }

    @Test
    void createPatient() throws IOException {

        when(iPatientRepository.save(any(Patient.class))).thenReturn(patientLia);

        Patient newPatient = patientService.createPatient(patientLia);

        assertNotNull(newPatient);
        assertEquals(2, newPatient.getId());
        assertEquals("Lia", newPatient.getName());
        assertEquals(5, newPatient.getAge());
        assertEquals("Female", newPatient.getSex());
        assertEquals("Water dog", newPatient.getRace());
        assertEquals(4539, newPatient.getNumberId());
        assertEquals("Kratos", newPatient.getTutorIsName());
        assertEquals("Onubense", newPatient.getTutorIsLastName());
        assertEquals(615895746, newPatient.getTutorPhone());

        MockMultipartFile photo2 = new MockMultipartFile("photo", "photo.jpg", "image/jpeg", "photo-content".getBytes());


        assertArrayEquals("photo-content".getBytes(), newPatient.getPhoto());

        verify(iPatientRepository, times(1)).save(patientLia);
    }
    @Test
    void deletePatientByIdTest() {
        int id = 2;
        patientService.deletePatientById(id);
        verify(iPatientRepository).deleteById(id);
    }

    @Test
    void getAllPatients() {
        List<Patient> patientList = new ArrayList<>();
        patientList.add(patientBolita);
        patientList.add(patientLia);

        when(iPatientRepository.findAll()).thenReturn(patientList);

        List<Patient> allPatients = patientService.getAllPatients();

        assertNotNull(allPatients);
        assertEquals(2, allPatients.size());
        assertTrue(allPatients.contains(patientBolita));
        assertTrue(allPatients.contains(patientLia));
        verify(iPatientRepository, times(1)).findAll();
    }

    @Test
    void getPatientById() {
        when(iPatientRepository.findById(anyInt())).thenReturn(Optional.of(patientBolita));

        Optional<Patient> foundPatient = patientService.getPatientById(1);

        assertTrue(foundPatient.isPresent());
        assertEquals(patientBolita.getId(), foundPatient.get().getId());
        assertEquals(patientBolita.getName(), foundPatient.get().getName());
        verify(iPatientRepository, times(1)).findById(1);
    }

}
