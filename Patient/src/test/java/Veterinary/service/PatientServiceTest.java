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
    private Patient patientBolita
    private ArrayList<Patient> patientList = new ArrayList<>();


    @Mock
    private PatientRepository patientRepository;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);

        patientLia = new Patient();
        patientLia.setId(1);
        patientLia.setName("Lia");
        patientLia.setAge(5);
        patientLia.setRace("Perro de agua");
        patientLia.setSex("Femenino");
        patientLia.setNumberId();
        patientLia.setTutorIsName("JM");
        patientLia.setTutorIsLastName("Polvillo");
        patientLia.setTutorPhone(666-66666);

        patientBolita = new Patient();
        patientBolita.setId(2);
        patientBolita.setName("Bolita");
        patientBolita.setAge();
        patientBolita.setRace();
        patientBolita.setSex();
        patientBolita.setNumberId();
        patientBolita.setTutorIsName();
        patientBolita.setTutorIsLastName();
        patientBolita.setTutorPhone();
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