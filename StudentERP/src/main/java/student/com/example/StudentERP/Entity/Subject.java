package student.com.example.StudentERP.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.security.Principal;
@Getter
@Setter
@Entity
@Table(name="Subjectdb")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int sId;
    @NotBlank(message = "Name cannot be null")
    private String name;
 @Column(unique = true)
     private  String subcode;

    private String edition;

     private String description;
     @ManyToOne
     private Student student;
     public Subject(){}

    @Override
    public String toString() {
        return "Subject{" +
                "sId=" + sId +
                ", name='" + name + '\'' +
                ", subcode='" + subcode + '\'' +
                ", edition='" + edition + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
