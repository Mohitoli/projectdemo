package project1com.example.project.demo.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import project1com.example.project.demo.Entity.User;
@Repository
public interface UserRepository extends  CrudRepository<User,Integer> {
    @Query("select u from User u where u.email=:email")
    public User getUserByUserName(@Param("email") String email);

}
