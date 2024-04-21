package demo2.com.example.demo2.RestController;

import demo2.com.example.demo2.Entity.UserEntity;
import demo2.com.example.demo2.Service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

   public final Logger logger=LoggerFactory.getLogger(UserEntity.class);
    @Autowired
    public UserService userService;

    @PostMapping(value = "/Register")
    public UserEntity savedata(@RequestBody UserEntity entity){
        logger.info("Inside the savedata");
        return this.userService.saventity(entity);
    }
    @GetMapping(value = "/getall")
    public List<UserEntity>getallemp(){
        return this.userService.getallemp();
    }
    @GetMapping(value = "/getemp/{id}")
    public UserEntity getemp(@PathVariable("id") int id) throws Exception{
      Optional<UserEntity> userEntity= this.userService.getemp(id);
      if (!userEntity.isPresent()){
          throw new Exception("User Not Found Exception");
      }
      return userEntity.get();


    }
    @DeleteMapping(value = "delete/{id}")
    public String deletemp(@PathVariable("id") int id){
        this.userService.Deleteemp(id);
        return "This is succesfully deleted";
    }
    @PutMapping(value = "update/{id}")
    public UserEntity updatemp(@PathVariable("id") int id,@RequestBody UserEntity entity){
        return this.userService.updateemp(id,entity);
    }
}
