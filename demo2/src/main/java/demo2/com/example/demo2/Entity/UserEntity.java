package demo2.com.example.demo2.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
@Data
@Entity
@Table(name ="Empstat", schema = "Public", catalog = "DemoProject")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "EMP_ID")
    private int id;
    private String name;
    private String course;

     public UserEntity(int id,String name,String course){
         this.id=id;
         this.name=name;
         this.course=course;
     }
//     public int getId(int id){
//         return id;
//     }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getCourse() {
//        return course;
//    }
//
//    public void setCourse(String course) {
//        this.course = course;
//    }
    public UserEntity(){}
}
