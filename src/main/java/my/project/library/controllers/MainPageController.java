package my.project.library.controllers;


import my.project.library.security.UserDetailsImpl;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainPageController {

    @GetMapping()
    public String mainPage(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication.getPrincipal() != "anonymousUser") {
            UserDetailsImpl userDetailsImpl = (UserDetailsImpl) authentication.getPrincipal();
            System.out.println(userDetailsImpl.getUser().getName());
        }
        return "index";
    }
}
