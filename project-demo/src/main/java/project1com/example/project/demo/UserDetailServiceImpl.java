package project1com.example.project.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import project1com.example.project.demo.Configuration.CustomUserDetails;
import project1com.example.project.demo.Entity.User;
import project1com.example.project.demo.Repository.UserRepository;

public class UserDetailServiceImpl implements UserDetailsService {
     @Autowired
    private UserRepository  userRepository;
    @Override
    //fetching data from database
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user= userRepository.getUserByUserName(username);
        if (user==null){
            throw new UsernameNotFoundException("Couldn't found user");
        }
        CustomUserDetails customUserDetails= new CustomUserDetails(user);

        return customUserDetails;
    }
}
