package project1com.example.project.demo.EmailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import project1com.example.project.demo.Controller.ForgetpasswordController;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;
    public void sendEmailMesage(String toEmail, String body, String subject){

        SimpleMailMessage message1 = new SimpleMailMessage();
        message1.setFrom("mohitsingholi07@gmail.com");
        message1.setTo(toEmail);
        message1.setText(body);
        message1.setSubject(subject);


        javaMailSender.send(message1);


    }



}
