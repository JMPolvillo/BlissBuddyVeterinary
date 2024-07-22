package Veterinary.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor

public class Appointments {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)

    @Column
    private int id;

    @Column(name = "dateTime")
    private LocalDateTime dateTime;

    @Column(name = "typeOfConsultation")
    private String typeOfConsultation;

    @Column(name = "motif")
    private String motif;

    @Column(name = "state")
    private String state;

    @ManyToOne
    private Patient patient;
}
