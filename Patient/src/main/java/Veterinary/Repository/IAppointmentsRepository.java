package Veterinary.Repository;

import Veterinary.model.Appointments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAppointmentsRepository extends JpaRepository<Appointments, Integer> {

   }
