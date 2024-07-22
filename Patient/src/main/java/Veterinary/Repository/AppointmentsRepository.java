package Veterinary.Repository;

import Veterinary.model.Appointments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentsRepository extends JpaRepository<Appointments, Integer> {

    static void findById(Appointments appointments) {
    }
}
