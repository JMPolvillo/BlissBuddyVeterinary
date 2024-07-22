package Veterinary.Repository;

import Veterinary.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository <Patient, Integer> {

    static void findById(Patient patient) {
    }
}
