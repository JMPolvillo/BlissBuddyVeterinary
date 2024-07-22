package Veterinary.controller;

import Veterinary.model.Appointments;
import Veterinary.service.AppointmentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*")

public class AppointmentsController {
    @Autowired
    AppointmentsService appointmentsService;

    @DeleteMapping(path = "/appointments")
    public void deleteAppointment(@RequestBody Appointments appointments){  
    }

    //@DeleteMapping(path = "/appointments/{id}")
    //public void deleteAppointmentById(int id){
    //}

}
