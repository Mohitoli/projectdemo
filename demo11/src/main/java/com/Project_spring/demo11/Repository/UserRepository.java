package com.Project_spring.demo11.Repository;

import com.Project_spring.demo11.Entity.UserEntity;
import org.apache.catalina.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<UserEntity,Integer> {

     public UserEntity findByname(String name);
     public UserEntity findBynameIgnoreCase(String name);
}
