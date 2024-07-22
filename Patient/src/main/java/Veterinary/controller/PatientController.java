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

    @PutMapping(path = "/api/{id}")
    private void updatePatient(@RequestBody Patient patient, @PathVariable int id){
        patientService.updatePatient(patient, id);
    }

}
