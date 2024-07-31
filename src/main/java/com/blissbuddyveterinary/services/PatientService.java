package com.blissbuddyveterinary.services;

import com.blissbuddyveterinary.repositories.IPatientRepository;
import com.blissbuddyveterinary.models.Patient;
import com.blissbuddyveterinary.models.PatientDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
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
    private Patient convertDtoToEntity(PatientDto patientDto) throws IOException {
        Patient patient = new Patient();
        patient.setName(patientDto.getName());
        patient.setRace(patientDto.getRace());
        patient.setAge(patientDto.getAge());
        patient.setSex((patientDto.getSex()));

        if (patientDto.getPhoto() != null && !patientDto.getPhoto().isEmpty()) {
            patient.setPhoto(patientDto.getPhoto().getBytes());
        }
        return patient;
    }
}
