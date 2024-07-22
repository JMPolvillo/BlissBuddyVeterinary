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
    PatientRepository patientRepository;

    public Patient createPatient(Patient patient) {
        return patientRepository.save(patient);
    }

public List<Patient> getAllPatients() {
    try {
        return patientRepository.findAll();
    } catch (Exception e) {
        throw new RuntimeException("Error retrieving patients", e);
    }
}

public Optional<Patient> getPatientById(int id) {
    try {
        return patientRepository.findById(id);
    } catch (Exception e) {
        throw new RuntimeException("Error retrieving patient by id", e);
    }

}
public void updatePatient(Patient patient, int id){
    patient.setId(id);
    PatientRepository.findById(patient);
    }

    public void deletePatient(Patient patient){
        patientRepository.delete(patient);
    }
    //public void deletePatientById (Long id){
        //patientRepository.deleteById(id);
    //}
}


