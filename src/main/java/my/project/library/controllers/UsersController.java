package my.project.library.controllers;

import jakarta.validation.Valid;
import my.project.library.models.User;
import my.project.library.services.PasswordsService;
import my.project.library.services.UsersService;
import my.project.library.utill.validators.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UsersController {

    private final UsersService usersService;
    private final UserValidator userValidator;
    private final PasswordsService passwordsService;

    @Autowired
    public UsersController(UsersService usersService,
                           UserValidator userValidator,
                           PasswordsService passwordsService) {
        this.usersService = usersService;
        this.userValidator = userValidator;
        this.passwordsService = passwordsService;
    }

    @GetMapping()
    public String getUsers(Model model){
        model.addAttribute("users", usersService.findAll());
        model.addAttribute("passwords",passwordsService.findAll());
        return "users/index";
    }


    @GetMapping("/{id}")
    public String show(@PathVariable("id") long id, Model model){
        return "users/show";
    }

    @GetMapping("/new")
    public String newUser(Model model){
        model.addAttribute("user", new User());
        return "users/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") @Valid User user, BindingResult bindingResult){
        userValidator.validate(user, bindingResult);
        if(bindingResult.hasErrors())
            return "users/new";
        //usersService.save(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") long id){
        return "users/edit";
    }


    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") @Valid User user, BindingResult bindingResult, @PathVariable("id") long id){
        userValidator.validate(user, bindingResult);
        if(bindingResult.hasErrors())
            return "users/edit";

//        usersService.update(id, user);
        return "redirect:/users/" + id;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") long id){
//        usersService.delete(id);
        return "redirect:/users";
    }
}
