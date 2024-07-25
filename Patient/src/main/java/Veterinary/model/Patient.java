package Veterinary.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;

import java.util.List;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor

public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @Column(name = "race")
    private String race;

    @Column(name = "sex")
    private String sex;

    @NaturalId
    @Column(name = "numberId", nullable = false, unique = true)
    private int numberId;

    @Column(name = "tutorIsName")
    private String tutorIsName;

    @Column(name = "tutorIsLastName")
    private String tutorIsLastName;

    @Column(name = "tutorPhone")
    private int tutorPhone;


}
