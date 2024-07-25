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


}
