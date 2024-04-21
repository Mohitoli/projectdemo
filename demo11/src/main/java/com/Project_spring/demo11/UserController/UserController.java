package com.Project_spring.demo11.UserController;


import com.Project_spring.demo11.Entity.UserEntity;
import com.Project_spring.demo11.Error.UserNotFoundException;
import com.Project_spring.demo11.Repository.UserRepository;
import com.Project_spring.demo11.Services.UserServices;
import jakarta.validation.Valid;
import org.apache.catalina.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class UserController {
    @Autowired
    public UserServices userServices;

// Post new user to Database

     @PostMapping(value = "/User")
     public UserEntity saveentity(@Valid  @RequestBody UserEntity userEntity ){
      return  userServices.saveentity(userEntity);
     }
       //Get all Userdata
    public final Logger logger = LoggerFactory.getLogger(UserController.class);
     @GetMapping(value = "/User")
     public List<UserEntity> getuser(){
         logger.info("Inside getuser of UserController ");
         return userServices.showallentity();
     }
        //Get individual Userdata using ID
     @GetMapping(value = "/User/{id}")
     public UserEntity getuserbyid(@PathVariable("id") int id)
             throws UserNotFoundException {
         return userServices.getbyid(id);
     }
     //Delete User through id

     @DeleteMapping(value = "/User/{id}")
    public String deleteuser(@PathVariable("id") int id ){
         userServices.deletebyid(id);
         return "Successfully Deleted";
     }

     @PutMapping(value = "/User/{id}")
         public UserEntity updatedata ( @PathVariable("id") int id, @RequestBody UserEntity userentity){
             return userServices.updateuserdata(id, userentity);
         }
         @GetMapping(value = "/User/name/{name}")
         public UserEntity getbyname(@PathVariable("name")String name){
         return userServices.getuserbyname(name);
         }



   }





