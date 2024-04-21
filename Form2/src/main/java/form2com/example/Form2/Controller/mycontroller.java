package form2com.example.Form2.Controller;

import form2com.example.Form2.Entity.UserEntity;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class mycontroller {
    @GetMapping(value = "/form1")
    public String loginform(Model model){
        model.addAttribute("loginform", new UserEntity());
        return "form";
    }
    @PostMapping(value = "/process")
    public String loginvalue(@Valid @ModelAttribute("loginform") UserEntity entity, BindingResult result){
        if(result.hasErrors()){
            return "form";
        }
        return "Success";
    }
}
