package Veterinary.service;

import Veterinary.Repository.PatientRepository;
import Veterinary.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

public List<Patient> getAllPatients() {
    try {
        return patientRepository.findAll();
    } catch (Exception e) {
        throw new RuntimeException("Error retrieving patients", e);
    }
}

public Optional<Patient> getPatientById(Long id) {
    try {
        return patientRepository.findById(id);
    } catch (Exception e) {
        throw new RuntimeException("Error retrieving patient by id", e);
    }
}

}