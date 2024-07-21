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

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @Column(name = "race")
    private String race;

    @Column(name = "gender")
    private String gender;

    @Column(name = "numberId")
    private String numberId;

    @Column(name = "tutorIsname")
    private String tutorIsName;

    @Column(name = "tutorIsLastName")
    private String tutorIsLastName;

    @Column(name = "tutorPhone")
    private String tutorPhone;
}
