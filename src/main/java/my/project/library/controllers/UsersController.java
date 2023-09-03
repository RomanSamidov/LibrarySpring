package my.project.library.controllers;

import jakarta.validation.Valid;
import my.project.library.models.User;
import my.project.library.models.enums.searchFields.UsersSearchFields;
import my.project.library.models.enums.sortings.UsersSorting;
import my.project.library.services.UsersService;
import my.project.library.utill.validators.ForPages;
import my.project.library.utill.validators.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@Controller
@RequestMapping("/users")
public class UsersController {

    private final UsersService usersService;
    private final UserValidator userValidator;

    @Autowired
    public UsersController(UsersService usersService,
                           UserValidator userValidator) {
        this.usersService = usersService;
        this.userValidator = userValidator;
    }

    @GetMapping()
    public String index(@RequestParam(value = "startingWith", required = false) String startingWith,
                        @RequestParam(value = "sort", required = false, defaultValue = "id_asc") UsersSorting sort,
                        @RequestParam(value = "search", required = false, defaultValue = "name") UsersSearchFields searchField,
                        @RequestParam(value = "page", required = false, defaultValue = "1") int page,
                        @RequestParam(value = "size", required = false, defaultValue = "5") int size,
                        Model model){

        model.addAttribute("sorting", Arrays.stream(UsersSorting.values()).toList());
        model.addAttribute("searchFields", Arrays.stream(UsersSearchFields.values()).toList());


//        model.addAttribute("users", usersService.findAll());
//        Pageable pageable = new PageA
//        model.addAttribute("users", usersService.findAllWithAuthoritiesAndLanguage(pageable));

        if(startingWith == null || startingWith.isEmpty()){
            long quantity = usersService.countAll();
            page = ForPages.checkAndSaveValuesForPagination(page, size, quantity, model);

            model.addAttribute("users", usersService.findAllWithAuthoritiesAndLanguage(page, size, sort));
        } else {
            long quantity = usersService.countAllStartingWith(startingWith, searchField);
            page = ForPages.checkAndSaveValuesForPagination(page, size, quantity, model);

            model.addAttribute("startingWith", startingWith);
            model.addAttribute("users", usersService.findAllStartingWithWithAuthoritiesAndLanguage(startingWith, page, size, sort, searchField));
        }


        return "users/index";
    }


    @GetMapping("/{id}")
    public String show(@PathVariable("id") long id, Model model){
        model.addAttribute("user", usersService.findOne(id).get());
        return "users/show";
    }

    @GetMapping("/new")
    public String newUser(Model model, @ModelAttribute("user") User user){
        if(user == null) {
            model.addAttribute("user", new User());
        }
        return "users/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") @Valid User user, BindingResult bindingResult){
        userValidator.validate(user, bindingResult);
        if(bindingResult.hasErrors())
            return "users/new";
        usersService.save(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") long id, Model model){
        model.addAttribute("user", usersService.findOne(id).get());
        return "users/edit";
    }


    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") @Valid User user, BindingResult bindingResult, @PathVariable("id") long id){
        userValidator.validate(user, bindingResult);
        if(bindingResult.hasErrors())
            return "users/edit";
        usersService.update(id, user);
        return "redirect:/users/" + id;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") long id){
        usersService.delete(id);
        return "redirect:/users";
    }
}
