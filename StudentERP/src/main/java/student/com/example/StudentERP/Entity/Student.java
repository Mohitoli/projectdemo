package student.com.example.StudentERP.Entity;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Data
@Entity
@Table(name = "Student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int id;
    @NotBlank(message =" Name cannot be empty")
    private String name;
    @NotBlank(message = "Course cannot be null")
    private String course;
    @Column(unique = true)
    @NotBlank(message = "Email cannot be null")
    private String email;
    @NotBlank(message = "Password cannot be null")
    private String password;
    private String studentimage;
    private String role;
    @Column(length = 500)
    private String about;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy ="student")
     private List<Subject> subject = new ArrayList<>();
    public Student(){}
}

