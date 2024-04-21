package demo2.com.example.demo2.Service;

import demo2.com.example.demo2.Entity.UserEntity;
import demo2.com.example.demo2.Repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class Serviceimpl implements UserService{
    public UserRepository userRepository;
    public Serviceimpl(UserRepository userRepository){
        super();
        this.userRepository=userRepository;
    }
    public UserEntity saventity(UserEntity entity){
        return userRepository.save(entity);
    }

     public List<UserEntity>getallemp(){
        return (List<UserEntity>)userRepository.findAll();
     }
     public Optional<UserEntity> getemp( int id){
      return  this.userRepository.findById(id);
     }
     public void Deleteemp(int id){
        this.userRepository.deleteById(id);
     }
     public UserEntity updateemp(int id,UserEntity entity){
       this.userRepository.findById(id).get();
       return userRepository.save(entity);
     }
}
