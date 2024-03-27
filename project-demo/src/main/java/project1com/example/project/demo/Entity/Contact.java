package project1com.example.project.demo.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@Entity
@Table(name = "CONTACT")

public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int cId;
    private String name;
    private String secondName;
    private String work;
    @Column(unique = true)
     private String email;
     private String phone;
     private String Stringimageurl;
     @Column(length = 500)
     private  String description;

     @ManyToOne
     private User user;
     public Contact(){}

    @Override
    public String toString() {
        return "Contact{" +
                "cId=" + cId +
                ", name='" + name + '\'' +
                ", secondName='" + secondName + '\'' +
                ", work='" + work + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", Stringimageurl='" + Stringimageurl + '\'' +
                ", description='" + description + '\'' +
                ", user=" + user +
                '}';
    }
}
