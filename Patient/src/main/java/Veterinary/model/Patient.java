package Veterinary.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor

public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column
    private long id;

    @Column
    private String name;

    @Column
    private int age;

    @Column
    private String race;

    @Column
    private String gender;

    @Column
    private String numberId;

    @Column
    private String tutorIsName;

    @Column
    private String tutorIsLastName;

    @Column
    private String tutorPhone;
}
