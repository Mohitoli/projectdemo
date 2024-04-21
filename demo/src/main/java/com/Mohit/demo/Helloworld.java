package com.Mohit.demo;

import jakarta.persistence.*;
import org.springframework.web.bind.annotation.*;


@RestController
public class Helloworld {

    @GetMapping(value ="/home")
    public String helloworld(){

        return "Hey this is me Mohit";
    }


}
