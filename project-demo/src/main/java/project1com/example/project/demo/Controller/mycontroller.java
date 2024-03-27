package project1com.example.project.demo.Controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.aspectj.bridge.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.condition.RequestConditionHolder;
import project1com.example.project.demo.Entity.User;
import project1com.example.project.demo.Helper.Helpermessage;
import project1com.example.project.demo.Repository.UserRepository;

import java.lang.reflect.Type;

@Controller

public class mycontroller {
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;
@GetMapping(value = "/Home")
    public String home(Model model){
    //model.addAttribute("title","THis is Dynamic data");
        return "home";

    }
    @GetMapping(value = "/About")
    public String about(){
    return "about";
    }
    @GetMapping(value = "/Signup")
    public String sign(Model model){
    model.addAttribute("user", new User());

        return "signup";
    }
    @GetMapping(value ="/Signin")
    public String customlogin(){
    return "login";
    }



    @PostMapping(value="/do_register")
    public String registeruser(@Valid @ModelAttribute("user") User user,BindingResult validresult, @RequestParam(value = "agreement",defaultValue = "false") boolean agreement, Model model,HttpSession session ){

    try {
        if (!agreement){
        throw new Exception("You have not agreed the terms and conditions");


        }
        if (validresult.hasErrors()){
            model.addAttribute("user",user);
            return "signup";
        }
        user.setRole("ROLE_USER");
        user.setEnabled(true);
        user.setPassword((passwordEncoder.encode(user.getPassword())));
       User result= this.userRepository.save(user);
        model.addAttribute("user",result);
        session.setAttribute("message",new Helpermessage("Successfully Registered", "alert-success"));

        return "signup";
    } catch (Exception e){
        e.printStackTrace();
        model.addAttribute("user",user);
        session.setAttribute("message",new Helpermessage("Something Went Wrong!! " +e.getMessage(), "alert-danger"));
        return "signup";
    }

    }


}

