package student.com.example.StudentERP.StudentController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import student.com.example.StudentERP.Entity.Student;
import student.com.example.StudentERP.Repository.StudentRepository;
import student.com.example.StudentERP.Repository.SubjectRepository;

import java.security.Principal;
import java.security.PrivateKey;

@Controller
@RequestMapping(value = "/student")
public class SubjectController {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private SubjectRepository subjectRepository;

   @ModelAttribute
    public void Addinfodashboard(Model model, Principal principal){
       String username= principal.getName();
        Student student=this.studentRepository.getUserByUserName(username);
        model.addAttribute("subject",student );

    }


    @GetMapping(value = "/index")
    public String dashboard(Model model){

          return "StudentDashboard";
    }

    @GetMapping(value = "/add-subject")

    public String addsubject(){
       return "add-subject";
    }



}
