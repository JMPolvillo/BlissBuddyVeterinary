package Veterinary.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class PatientDto {

    private int id;
    private String name;
    private int age;
    private String race;
    private String sex;
    private String tutorFullName;
    private MultipartFile photo;



}
