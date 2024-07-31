package Veterinary.service;

import Veterinary.Repository.IPatientRepository;
import Veterinary.model.Patient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
class PatientServiceTest {

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
    void updatePatient() {
        when(iPatientRepository.save(any(Patient.class))).thenReturn(patientBolita);

        Patient patientToUpdate = new Patient();
        patientToUpdate.setNumberId(1);
        patientToUpdate.setName("UpdatedBolita");
        patientToUpdate.setTutorIsName("UpdatedIsabé");


        patientService.updatePatient(patientToUpdate, 1);
        assertEquals(1, patientToUpdate.getId());
        verify(iPatientRepository, times(1)).save(patientToUpdate);
    }

}