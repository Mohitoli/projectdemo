package thymeleaf.com.example.Practice.thymeleaf.Controller;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@Controller
public class MyController {
    @RequestMapping(value = "/about",method = RequestMethod.GET)

    public String about(Model model){
        model.addAttribute("name","Mohit oli");
        model.addAttribute("CurrentDate",new Date().getDate());
        return "about";
    }
    @GetMapping(value = "/loops")
    public String iteratehandle(Model model){
        List<String> names=List.of("mohit","shuru","simran","yatish");
        model.addAttribute("names",names);
        return "iterate" ;
    }
    @GetMapping(value = "/Conditions")
    public String Conditions(Model model){
        model.addAttribute("isActive",false);
        model.addAttribute("Gender","F");
        List<Integer> list = List.of(233,344,45,345);
        model.addAttribute("mylist",list);
        return "ConditionalHandler";
    }
    @GetMapping(value = "/service")
    public String serviceing(Model model){
model.addAttribute("title","This is controller value");
        return "service";
    }
    @GetMapping(value ="/newabout")
    public String aboutt(){
        return "newabout";
    }
}
