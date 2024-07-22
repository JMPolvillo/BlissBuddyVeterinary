package Veterinary.controller;

import Veterinary.service.AppointmentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*")

public class AppointmentsController {
    @Autowired
    AppointmentsService appointmentsService;

}
