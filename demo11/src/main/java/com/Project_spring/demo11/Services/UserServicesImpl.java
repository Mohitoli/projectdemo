package com.Project_spring.demo11.Services;

import com.Project_spring.demo11.Entity.UserEntity;
import com.Project_spring.demo11.Error.UserNotFoundException;
import com.Project_spring.demo11.Repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserServicesImpl implements UserServices {
    @Autowired
    public UserRepository userRepository;
 public UserServicesImpl (UserRepository userRepository){
     super();
     this.userRepository =userRepository;
 }
   //
    public UserEntity saveentity(UserEntity entity){
        return userRepository.save(entity);
    }

    @Override
    public List<UserEntity> showallentity() {
        return (List<UserEntity>) userRepository.findAll();
    }

    @Override
    public UserEntity getbyid(int id) throws UserNotFoundException {
        Optional<UserEntity> userEntity= userRepository.findById(id);

         if (!userEntity.isPresent()){
             throw  new UserNotFoundException("User Not Found");

         }
        return userEntity.get();

 }
       public void deletebyid(int id){
      userRepository.deleteById(id);
       }
       public UserEntity updateuserdata(int id, UserEntity entity) {
           UserEntity dbentity = userRepository.findById(id).get();

          if (Objects.nonNull(entity.getName()) &&
              !"".equalsIgnoreCase(entity.getName())){
              dbentity.setName(entity.getName());
          }
           return userRepository.save(dbentity);
       }

    @Override
    public UserEntity getuserbyname(String name) {
        return userRepository.findBynameIgnoreCase(name);
    }
}
