package demo2.com.example.demo2.Repository;

import demo2.com.example.demo2.Entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity,Integer> {
}
