package portfolio.com.example.portfolio;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class mycontroller {
    @Autowired
   public JavaMailSender MailSender;
    @GetMapping(value = "/Portfolio")
    public String portfolio(){

        return "open_portfolio";
    }
//    @GetMapping(value = "/Portfolio/Contact")
//    public String Contact(){
//        return "p";
//    }
    @PostMapping(value = "/Mail")
    public String mailservice(@RequestParam String email, String message, String subject){
        SimpleMailMessage message1 = new SimpleMailMessage();
        message1.setTo("mohitsingholi07@gmail.com");
        message1.setFrom(email);
        message1.setSubject(subject);
        message1.setText(message);
        this.MailSender.send(message1);
        return "open_portfolio";
    }

}
