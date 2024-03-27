package project1com.example.project.demo;

import jakarta.servlet.http.HttpSession;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
@Component
public class sessionHelper {

    public void removemessagefromsession(){
        try{

         HttpSession session= ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getSession();
            session.removeAttribute("message");

    } catch(Exception e){
        e.printStackTrace();
    }
    }
/*
    public void removemessagefromsession2(){
        try{

            HttpSession session= ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getSession();
            session.removeAttribute("message");

        } catch(Exception e){
            e.printStackTrace();
        }
       }
 */

}
