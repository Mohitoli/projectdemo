package com.Mohit.demo.Controller;

import com.Mohit.demo.Entities.UserEntity;
import com.Mohit.demo.Services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class Usercontroller {
public UserService userService;

public Usercontroller(UserService userService){
    super();
    this.userService=userService;

}
@PostMapping(value = "/Employee")
 public ResponseEntity<UserEntity> saveentity(@RequestBody UserEntity entity){
 return  new ResponseEntity<UserEntity>(userService.SaveEntity(entity), HttpStatus.CREATED);
 }





}
