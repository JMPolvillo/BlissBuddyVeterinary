package Veterinary.service;

import Veterinary.Repository.AppointmentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class AppointmentsService {
    @Autowired
    AppointmentsRepository appointmentsRepository;

}
