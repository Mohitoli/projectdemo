package com.Project_spring.demo11.Services;

import com.Project_spring.demo11.Entity.UserEntity;
import com.Project_spring.demo11.Error.UserNotFoundException;
import org.springframework.boot.autoconfigure.security.SecurityProperties;

import java.util.List;

public interface UserServices {
   public UserEntity saveentity(UserEntity entity);
    public List<UserEntity> showallentity();

     public UserEntity getbyid(int id) throws UserNotFoundException;
           public void deletebyid(int id);
           public UserEntity updateuserdata(int id,UserEntity entity);
           public UserEntity getuserbyname(String name);
}
