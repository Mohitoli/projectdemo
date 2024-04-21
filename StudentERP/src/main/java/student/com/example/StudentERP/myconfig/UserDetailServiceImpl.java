package student.com.example.StudentERP.myconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import student.com.example.StudentERP.Entity.Student;
import student.com.example.StudentERP.Repository.StudentRepository;
import student.com.example.StudentERP.myconfig.CustomUserDetail;

public class UserDetailServiceImpl implements UserDetailsService {

     @Autowired
     private StudentRepository studentRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Student student= this.studentRepository.getUserByUserName(username);
         if (student==null){
             throw new UsernameNotFoundException("User Not Found");

         }

        CustomUserDetail customUserDetail = new CustomUserDetail(student);


        return customUserDetail;
    }
}
