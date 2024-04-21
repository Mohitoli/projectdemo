package com.Mohit.demo.Services;

import com.Mohit.demo.Entities.UserEntity;
import com.Mohit.demo.Repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class serviceimpl implements UserService {

    public UserRepository userRepository;

     public serviceimpl(UserRepository userRepository){
         this.userRepository=userRepository;
     }
      public UserEntity SaveEntity(UserEntity entity){
         return userRepository.save(entity);
      }



}
