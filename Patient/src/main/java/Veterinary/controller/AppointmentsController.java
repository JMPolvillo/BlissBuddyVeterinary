package Veterinary.controller;

import Veterinary.model.Appointments;
import Veterinary.service.AppointmentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/appointments")
@CrossOrigin(origins = "*")
public class AppointmentsController {
    @Autowired
    AppointmentsService appointmentsService;

    @PostMapping(path = "/appointments")
    public Appointments createAppointments(@RequestBody Appointments appointment) {
        return appointmentsService.createAppointment(appointment);
    }

}

    @PutMapping(path = "/api/{id}")
    public void updateAppointments(@RequestBody Appointments appointments, @PathVariable int id){
      appointmentsService.updateAppointments(appointments, id);
    }


    @DeleteMapping(path = "/appointments")
    public void deleteAppointment(@RequestBody Appointments appointments){
    }

    //@DeleteMapping(path = "/appointments/{id}")
    //public void deleteAppointmentById(int id){
    //}

}
    @GetMapping
    public ResponseEntity<List<Appointments>> getAllAppointments() {
        try {
            List<Appointments> appointments = appointmentsService.getAllAppointments();
            return ResponseEntity.ok(appointments);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Appointments> getAppointmentById(@PathVariable Long id) {
        try {
            Optional<Appointments> appointment = appointmentsService.getAppointmentById(id);
            return appointment.map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.notFound().build());
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }
}