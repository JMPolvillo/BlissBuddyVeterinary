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

    @PutMapping(path = "/api/{id}")
    public void updateAppointments(@RequestBody Appointments appointments, @PathVariable int id){
      appointmentsService.updateAppointments(appointments, id);
    }


}
