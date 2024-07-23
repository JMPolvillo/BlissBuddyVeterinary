package Veterinary.controller;

import Veterinary.model.Patient;
import Veterinary.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*")

public class PatientController {
    @Autowired
    PatientService patientService;

    @PostMapping(path = "/patients")
    public Patient createPatient(@RequestBody Patient patient) {
        return patientService.createPatient(patient);
    }

    @PutMapping(path = "/api/{id}")
    private void updatePatient(@RequestBody Patient patient, @PathVariable int id) {
       patientService.updatePatient(patient, id);
    }

    @GetMapping
    public ResponseEntity<List<Patient>> getAllPatients() {
        try {
            List<Patient> patients = patientService.getAllPatients();
            return ResponseEntity.ok(patients);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable int id) {
        try {
            Optional<Patient> patient = patientService.getPatientById(id);
            return patient.map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.notFound().build());
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @DeleteMapping(path = "/patients")
    public void deletePatient(@RequestBody Patient patient) {
    }

    @DeleteMapping (path = "/patients/{id}")
    public String deletePatientById(@PathVariable int id){
        boolean ok = patientService.deletePatientById(id);
        if (ok) {
            return "Patient with id" + id + "was deleted";
        } else {
            return "Error, we have a problem to delete patient with id " + id;
        }
    }

}
