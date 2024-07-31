package com.blissbuddyveterinary.repositories;

import com.blissbuddyveterinary.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPatientRepository extends JpaRepository <Patient,Integer > {

}