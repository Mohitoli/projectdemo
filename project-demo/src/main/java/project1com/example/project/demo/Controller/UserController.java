package project1com.example.project.demo.Controller;

import jakarta.servlet.http.HttpSession;
import org.aspectj.bridge.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.parameters.P;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
import java.util.Optional;
import java.util.concurrent.Callable;

@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ContactRepository contactRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;




    //addind common data to response
    @ModelAttribute
    public void addacommondata(Model model, Principal principal) {
        String username = principal.getName();
        User user = userRepository.getUserByUserName(username);
        model.addAttribute("user", user);

    }

    //Dashboard Home
    @GetMapping(value = "/index")
    public String dashboard(Model model) {



        return "userdashboard";
    }

    @GetMapping(value = "/addcontact")
    public String contact(Model model) {
        model.addAttribute("contact", new Contact());

        return "add-contact";
    }

    @PostMapping(value = "/process-contact")
    public String processcontact(@ModelAttribute Contact contact,@RequestParam("profileimage")MultipartFile file, Principal principal, HttpSession session) {

        try {
            System.out.println(contact);
        String name = principal.getName();
        User user = this.userRepository.getUserByUserName(name);
        if(file.isEmpty()){
           contact.setStringimageurl("user.png");
           user.setStringimageurl("default.png");

        }
        else{
            //upload file to folder and update the name of contact
            contact.setStringimageurl(file.getOriginalFilename());
          File savefile = new ClassPathResource("static/img").getFile();
        Path path=  Paths.get(savefile.getAbsolutePath()+File.separator+file.getOriginalFilename());
          Files.copy(file.getInputStream(),path,StandardCopyOption.REPLACE_EXISTING);

        }

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

    @GetMapping(value ="/show-contact/{page}")
    public String showcontact(@PathVariable("page")Integer page, Model model,Principal p){
        String username= p.getName();
        User user= this.userRepository.getUserByUserName(username);
       Pageable pageable= PageRequest.of(page,2);

        Page<Contact> contacts= this.contactRepository.findContactsByUser(user.getId(),pageable);
          model.addAttribute("contacts",contacts);

        model.addAttribute("currentpage",page);
        model.addAttribute("totalpages",contacts.getTotalPages());



        return "show_contact";
    }

    @GetMapping(value = "/contact/{cId}")
    public String showcontactdetail(@PathVariable("cId") Integer cId, Model model,Principal principal){
          Optional<Contact> contactOptional=  this.contactRepository.findById(cId);
      Contact contact= contactOptional.get();
      String username=principal.getName();
     User user=this.userRepository.getUserByUserName(username);
     if(user.getId()==contact.getUser().getId()) {
         model.addAttribute("model", contact);
     }
        return "show_contactdetail";

    }
    @GetMapping(value="/delete/{cid}")
    public String deletecontact(@PathVariable("cid") Integer cId, Model model,HttpSession session){

      Optional<Contact> contactOptional= this.contactRepository.findById(cId);
      Contact contact= contactOptional.get();
      this.contactRepository.delete(contact);
     session.setAttribute("message",new Helpermessage("Contact Successfully Deleted","success"));


        return "redirect:/user/show-contact/0";
    }

    @PostMapping(value = "/update-contact/{cid}")
    public String updateform(@PathVariable("cid") Integer cid, Model model){
     Contact contact = this.contactRepository.findById(cid).get();
     model.addAttribute("contact", contact);
        return "update-form";
    }
    @PostMapping(value = "/process-update")
    public String updatehandler(@ModelAttribute Contact contact, @RequestParam("profileimage") MultipartFile file,Model m, HttpSession session, Principal principal ){

     try {
         Contact oldcontact= this.contactRepository.findById(contact.getCId()).get();//
         if (!file.isEmpty()){//when file is not empty

             File savefile = new ClassPathResource("static/img").getFile();
             Path path=  Paths.get(savefile.getAbsolutePath()+File.separator+file.getOriginalFilename());
             Files.copy(file.getInputStream(),path,StandardCopyOption.REPLACE_EXISTING);
               contact.setStringimageurl(file.getOriginalFilename());


         }
         else{
             contact.setStringimageurl(oldcontact.getStringimageurl());
         }
           String username=principal.getName();
         User  user= this.userRepository.getUserByUserName(username);
         contact.setUser(user);
       this.contactRepository.save(contact);
     session.setAttribute("message",new Helpermessage("Your data is updated Successfully", "success"));
     }catch (Exception e){
         e.printStackTrace();
     }

        return "redirect:/user/contact/"+contact.getCId();

         }

         @GetMapping(value = "/profile")
         public String yourprofile(){


         return "profile";
         }

          @GetMapping(value = "/setting")
          public String setting(){

             return "setting";
          }

         @PostMapping(value = "/changepassword")
         public String changepassword(@RequestParam("oldPassword") String oldpassword, @RequestParam("newPassword") String newpassword,Principal principal,HttpSession session){
             String username=principal.getName();
             User user= this.userRepository.getUserByUserName(username);

           if (this.bCryptPasswordEncoder.matches(oldpassword,user.getPassword())){
                user.setPassword(this.bCryptPasswordEncoder.encode(newpassword));
                this.userRepository.save(user);
                session.setAttribute("message", new Helpermessage("New Password Successfully Created", "success"));

           }
           else {
               session.setAttribute("message", new Helpermessage("Password is incorrect","danger"));
               return "redirect:/user/setting";
            }
             return "redirect:/user/index";
         }


}


