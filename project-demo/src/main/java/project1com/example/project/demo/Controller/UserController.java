package project1com.example.project.demo.Controller;

import jakarta.servlet.http.HttpSession;
import org.aspectj.bridge.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import project1com.example.project.demo.Entity.Contact;
import project1com.example.project.demo.Entity.User;
import project1com.example.project.demo.Helper.Helpermessage;
import project1com.example.project.demo.Repository.ContactRepository;
import project1com.example.project.demo.Repository.UserRepository;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ContactRepository contactRepository;

    //addind common data to response
    @ModelAttribute
    public void addacommondata(Model model, Principal principal) {
        String username = principal.getName();
        User user = userRepository.getUserByUserName(username);
        model.addAttribute("user", user);

    }

    //Dashboard Home
    @GetMapping(value = "/index")
    public String dashboard(Model model, Principal principal) {

        return "userdashboard";
    }

    @GetMapping(value = "/addcontact")
    public String contact(Model model) {
        model.addAttribute("contact", new Contact());

        return "add-contact";
    }

    @PostMapping(value = "/process-contact")
    public String processcontact(@ModelAttribute Contact contact, Principal principal, HttpSession session) {

        try {
            System.out.println(contact);
        String name = principal.getName();
        User user = this.userRepository.getUserByUserName(name);
        user.getContacts().add(contact);
            contact.setUser(user);
        this.userRepository.save(user);
                 session.setAttribute("message",new Helpermessage("Your Contact is Added Successfull  !!","success"));

        }
        catch (Exception e){
            e.printStackTrace();
            session.setAttribute("message",new Helpermessage("Something Went Wrong!!","danger"));

        }
        return "add-contact";
    }

    @GetMapping(value = "/show-contact/{page}")
    public String showcontact(@PathVariable("page")Integer page, Model model,Principal p){
        String username= p.getName();
        User user= this.userRepository.getUserByUserName(username);
       Pageable pageable= PageRequest.of(page,6);

        Page <Contact> contacts= this.contactRepository.findContactsByUser(user.getId(),pageable);
          model.addAttribute("contacts",contacts);
        model.addAttribute("currentpage",page);
        model.addAttribute("totalpages",contacts.getTotalPages());



        return "show_contact";
    }
}
