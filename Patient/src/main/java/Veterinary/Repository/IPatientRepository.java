package Veterinary.Repository;

import Veterinary.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPatientRepository extends JpaRepository <Patient,Integer > {




}
