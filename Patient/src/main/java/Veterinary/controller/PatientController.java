package Veterinary.controller;

import Veterinary.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import Veterinary.model.Patient;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*")

public class PatientController {
    @Autowired
    PatientService patientService;

    @DeleteMapping(path = "/patients")
    public void deletePatient(@RequestBody Patient patient){
    }

    //@DeleteMapping (path = "/patients/{id}")
    //public void deletePatientById(int id){
    //}

}
