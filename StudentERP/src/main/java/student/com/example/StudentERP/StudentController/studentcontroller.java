package student.com.example.StudentERP.StudentController;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import student.com.example.StudentERP.Entity.Student;
import student.com.example.StudentERP.Helper.HelperMessage;
import student.com.example.StudentERP.Repository.StudentRepository;

@Controller
public class studentcontroller {

@Autowired
public StudentRepository studentRepository;
@Autowired
public BCryptPasswordEncoder passwordEncoder;

@GetMapping(value = "/Home")
public String home(Model model){
model.addAttribute("title","this is dynamic data");
    return "home";
}
@GetMapping(value = "/About")
public String about(Model model){
    return "about";
}
@GetMapping(value ="/Signup")
    public String signup(Model model){

    model.addAttribute("student",new Student());
    return "signup";
}

    @GetMapping("/Signin")
    public String login(){
        return "login";
    }

@PostMapping(value = "/do-register")
public String registeruser(@ModelAttribute("student") Student student, @RequestParam(value = "agreement",defaultValue ="false") Boolean agreement , Model model, HttpSession session){

    try {
if (!agreement){

     throw new Exception("you have not agreed with the terms and condition");
}
        student.setRole("ROLE_STUDENT");
        student.setPassword(student.getPassword());
        student.setPassword(passwordEncoder.encode(student.getPassword()));
        Student result=this.studentRepository.save(student);
        model.addAttribute("student", result);
        session.setAttribute("message",new HelperMessage("You Have Successfully Register","alert-success" ));
        return "signup";
    }
    catch (Exception e){
        e.printStackTrace();

        model.addAttribute("student",student);
        session.setAttribute("message",new HelperMessage("Something went wrong!!"+e.getMessage(),"alert-danger"));
        return "signup";
    }

}


}
