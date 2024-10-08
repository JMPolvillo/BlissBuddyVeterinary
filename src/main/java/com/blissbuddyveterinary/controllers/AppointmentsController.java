package com.blissbuddyveterinary.controllers;

import com.blissbuddyveterinary.models.Appointments;
import com.blissbuddyveterinary.services.AppointmentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*")

public class AppointmentsController {
    @Autowired
    AppointmentsService appointmentsService;

    @PostMapping(path = "/appointments")
    public ResponseEntity<Appointments> createAppointments(@RequestBody Appointments newAppointments) {
        Appointments createdAppointments = appointmentsService.createAppointment(newAppointments);
        return new ResponseEntity<>(createdAppointments, HttpStatus.CREATED);
    }


    @PutMapping(path = "/appointments/{id}")
    public void updateAppointments(@RequestBody Appointments appointments, @PathVariable int id) {
        appointmentsService.updateAppointments(appointments, id);
    }


    @DeleteMapping(path = "/appointments")
    public void deleteAppointment(@RequestBody Appointments appointments) {
    }

    @DeleteMapping(path = "/appointments/{id}")
    public String deleteAppointmentById(@PathVariable int id) {
        boolean ok = appointmentsService.deleteAppointmentById(id);
        if (ok) {
            return "Appointment with id" + id + "was deleted";
        } else {
            return "Error, we have a problem trying to delete appointment with id " + id;
        }
    }

    @GetMapping(path = "/appointments")
    public ResponseEntity<List<Appointments>> getAllAppointments() {
        try {
            List<Appointments> appointments = appointmentsService.getAllAppointments();
            return ResponseEntity.ok(appointments);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @GetMapping(path = "/appointments/{id}")
    public ResponseEntity<Appointments> getAppointmentById(@PathVariable int id) {
        try {
            Optional<Appointments> appointment = appointmentsService.getAppointmentById(id);
            return appointment.map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.notFound().build());
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

}
