package my.project.library.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainPageController {
    // Login form
    @GetMapping("/login")
    public String login() {
        System.out.println("dsdsdssds");
        return "login";
    }
    @GetMapping()
    public String mainPage(){
        return "index";
    }
}
