package Form.com.example.Form.controller;

import Form.com.example.Form.Entities.UserEntity;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class mycontroller {
    @GetMapping(value ="/form")
    public String loginform(Model model){
        model.addAttribute("login", new UserEntity());
        return "form";
    }
    @PostMapping(value="/process")
    public String handlerform(@Valid @ModelAttribute("login") UserEntity userEntity, BindingResult result){
        if (result.hasErrors()) {

            return "form";
        }
        else {
        return "Success";
    }}
}
