package Veterinary.controller;

import Veterinary.model.Patient;
import Veterinary.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
