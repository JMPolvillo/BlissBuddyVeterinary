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

    @PostMapping(path = "/appointments")
    public Appointments createAppointments(@RequestBody Appointments appointment) {
        return appointmentsService.createAppointment(appointment);
    }

}
