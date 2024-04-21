package project1com.example.project.demo.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import project1com.example.project.demo.Entity.Contact;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Data
@Table(name = "USERTABLE")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int id;
    @NotBlank(message = "Username Cannot be empty")
    private String name;
    @Column(unique = true)
    @NotBlank(message = "Email cannot be empty")
     private  String email;
    @NotBlank(message = "Password Cannot be empty")
     private String password;
     private String role;
      private boolean enabled;
      private  String Stringimageurl;
      @Column(length = 500)
       private String about;


         @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "user")
       private List<Contact> contacts= new ArrayList<>();
 public User(){
     super();
 }
}

