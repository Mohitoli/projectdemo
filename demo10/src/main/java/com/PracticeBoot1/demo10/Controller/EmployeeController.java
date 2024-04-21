package com.PracticeBoot1.demo10.Controller;

import com.PracticeBoot1.demo10.Entity.Entites;
import com.PracticeBoot1.demo10.Exception.UserNotFoundException;
import com.PracticeBoot1.demo10.Service.Services;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.ValidationMode;
import jakarta.validation.Valid;
import lombok.extern.java.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Log
public class EmployeeController {
    @Autowired
    public Services empservice;
    @PostMapping(value = "/Employee")
    public Entites entites(@RequestBody Entites entites){
        return empservice.Createenitity(entites);
    }
    public Logger logger= LoggerFactory.getLogger(EmployeeController.class);

    @GetMapping(value = "/Employee")
    public List<Entites> getentity(){
        logger.info("This is Get all employee method");

        return empservice.Getentities();
    }
    @GetMapping(value = "/Employee/{id}")
    public Entites entites(@PathVariable("id") @RequestBody int id) throws UserNotFoundException{

        return empservice.Getempbyid(id);
    }
    @PutMapping(value = "Employee/{id}")

     public Entites updateemp(@Valid  @PathVariable("id")@RequestBody int id, Entites entites){
        return empservice.Updatebyid(id, entites);
    }

    @DeleteMapping(value = "/Employee/{id}")
    public String entities(@PathVariable("id") @RequestBody int id){
        empservice.Deletbyid(id);
        return "Successfully Deleted";
    }
    @GetMapping(value = "Employee/name/{name}")
    public Entites entites(@PathVariable("name") @RequestBody String name){
       return empservice.Getbyname(name);
    }

}
