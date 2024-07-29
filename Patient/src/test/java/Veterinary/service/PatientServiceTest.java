package Veterinary.service;

import Veterinary.Repository.AppointmentsRepository;
import Veterinary.Repository.PatientRepository;
import Veterinary.model.Appointments;
import Veterinary.model.Patient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PatientServiceTest {
    @InjectMocks
    private PatientService patientService;
    private Patient patientLia;
    private Patient patientBolita;
    private ArrayList<Patient> patientList = new ArrayList<>();


    @Mock
    private PatientRepository patientRepository;

    @BeforeEach
    public void setUp(){
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
    void createPatient() {
    }

    @Test
    void getAllPatients() {
    }

    @Test
    void getPatientById() {
    }

    @Test
    void updatePatient() {
    }

    @Test
    void deletePatient() {
    }

    @Test
    void deletePatientByIdTest() {
        int id = 2;
        patientService.deletePatientById(id);
        verify(patientRepository).deleteById(id);
    }
}