package demo2.com.example.demo2.Service;

import demo2.com.example.demo2.Entity.UserEntity;
import org.apache.catalina.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    public UserEntity saventity(UserEntity entity);
    public List<UserEntity >getallemp();
    public Optional<UserEntity> getemp(int id);
    public void Deleteemp(int id);
    public UserEntity updateemp(int id, UserEntity entity);

}

