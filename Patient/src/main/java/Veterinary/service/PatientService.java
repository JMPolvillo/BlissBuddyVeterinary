package Veterinary.service;

import Veterinary.Repository.IPatientRepository;
import Veterinary.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {
    @Autowired
    IPatientRepository iPatientRepository;

    public Patient createPatient(Patient patient) {
        return iPatientRepository.save(patient);
    }

    public List<Patient> getAllPatients() {
        try {
            return iPatientRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving patients", e);
        }
    }

    public Optional<Patient> getPatientById(int id) {
        try {
            return iPatientRepository.findById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving patient by id", e);
        }
    }

    public void updatePatient(Patient patient, int id) {
        patient.setId(id);
        iPatientRepository.save(patient);
    }

    public void deletePatient(Patient patient) {
        iPatientRepository.delete(patient);
    }

    public boolean deletePatientById(int id) {
        try {
            iPatientRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }


    }
}

