package project1com.example.project.demo.Controller;

import jakarta.persistence.Access;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import project1com.example.project.demo.EmailService.EmailService;
import project1com.example.project.demo.Entity.User;
import project1com.example.project.demo.Helper.Helpermessage;
import project1com.example.project.demo.Repository.UserRepository;

import java.util.Random;

@Controller
 public class ForgetpasswordController {
    @Autowired
    private EmailService emailService;
    @Autowired
    private UserRepository userRepository;

     @Autowired
     private BCryptPasswordEncoder bCryptPasswordEncoder;

      Logger logger = LoggerFactory.getLogger(ForgetpasswordController.class);

    Random random= new Random(1000);
     @GetMapping(value = "/forgot")
    public String openemailotp(){

         return "emailform";
     }
     @PostMapping(value = "/sendotp")
      public String verifyotp(@RequestParam("email") String email, HttpSession session){
         int otp= random.nextInt(10000);
         System.out.println(otp);
         String message= "OTP :"+ otp;
         session.setAttribute("myotp",otp);
         session.setAttribute("email",email);
       this.emailService.sendEmailMesage(email,message,"OTP FROM CONTACT MANAGER");


         return "verifyotp";
     }

     @PostMapping("/verify-otp")
    public String verify(@RequestParam("otp") int otp,HttpSession session) {
      Integer myotpObj= (Integer) session.getAttribute("myotp");
      if (myotpObj==null){
          session.setAttribute("message",new Helpermessage("OTP Not Found","danger"));
          System.out.println("null");
          logger.info("Throwing that there is no register of user by this email");
          return "verifyotp";
      }
       int myotp=myotpObj.intValue();
        String email = (String) session.getAttribute("email");

         if (myotp == otp) {
             //change password from email
             User user = this.userRepository.getUserByUserName(email);
             if (user == null) {
                session.setAttribute("message", new Helpermessage("User Doesn't Exist", "danger"));
                 System.out.println("user null");
                 return "emailform";
             }
             else {

             }
             return "password-change";

         }
         else {

             return "verifyotp";

         }

     }


  @PostMapping(value = "/change-password")
public String change(@RequestParam("newpassword") String newpasword,HttpSession session){

         String email=(String) session.getAttribute("email");
            User user=this.userRepository.getUserByUserName(email);
            user.setPassword(this.bCryptPasswordEncoder.encode(newpasword));
            this.userRepository.save(user);
            return "redirect:/Signin?change=password change Successfully";

  }

}