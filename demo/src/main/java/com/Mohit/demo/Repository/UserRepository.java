package com.Mohit.demo.Repository;

import com.Mohit.demo.Entities.UserEntity;
import org.apache.catalina.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity,Integer> {
}
