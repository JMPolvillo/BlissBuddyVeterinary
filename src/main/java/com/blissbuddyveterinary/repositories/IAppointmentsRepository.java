package com.blissbuddyveterinary.repositories;

import com.blissbuddyveterinary.models.Appointments;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IAppointmentsRepository extends JpaRepository<Appointments, Integer> {

}