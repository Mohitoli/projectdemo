package com.Project_spring.demo11.Entity;
import jakarta.persistence.*;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;
@Getter
@Setter
@Data
@Entity
@Table(name = "UserInfo",schema = "public",catalog = "DemoProject" )
public class UserEntity {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
 @NotBlank(message = "This should be added must")
    private String Course;

    public void setId(int id){
        this.id=id;
    }


    public void setName(String name){
        this.name=name;

    }
    public UserEntity(int id, String name){
        super();
        this.name=name;
        this.id=id;

    }
    public UserEntity(){

    }

}
