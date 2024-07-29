package Veterinary.service;

import Veterinary.Repository.PatientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

class PatientServiceTest {
    @InjectMocks
    private PatientService patientService;

    @Mock
    private PatientRepository patientRepository;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
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
    int id = 1;
    patientService.deletePatientById(id);
    verify(patientRepository).deleteById(id);
    }


}