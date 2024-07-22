package Veterinary.service;

import Veterinary.Repository.PatientRepository;
import Veterinary.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {
    @Autowired
    PatientRepository patientRepository;

public void updatePatient(Patient patient, int id){
    patient.setId(id);
    PatientRepository.findById(patient);
    }
}
