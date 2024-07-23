package Veterinary;

import Veterinary.controller.PatientController;
import Veterinary.service.PatientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringJUnitConfig
public class PatientControllerTests {

	@Mock
	private PatientService appointmentsService;

	@InjectMocks
	private PatientController appointmentsController;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}
}