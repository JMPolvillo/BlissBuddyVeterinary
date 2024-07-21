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
    private long id;

    @Column
    private LocalDateTime dateTime;

    @Column
    private String typeOfConsultation;

    @Column
    private String motif;

    @Column
    private String state;

    @ManyToOne
    private Patient patient;
}
