package my.project.library.controllers;

import jakarta.validation.Valid;
import my.project.library.models.Author;
import my.project.library.services.AuthorsService;
import my.project.library.utill.validators.AuthorValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/authors")
public class AuthorsController {
    private final AuthorsService authorsService;
    private final AuthorValidator authorValidator;

    @Autowired
    public AuthorsController(AuthorsService authorsService, AuthorValidator authorValidator) {
        this.authorsService = authorsService;
        this.authorValidator = authorValidator;
    }

    @GetMapping()
    public String index(Model model){
        // preparation to show all
        return "authors/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") long id, Model model){
        //preparation to show one
        return "authors/show";
    }

    @GetMapping("/new")
    public String newAuthor(Model model){
        model.addAttribute("author", new Author());
        return "authors/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("author") @Valid Author author, BindingResult bindingResult){
        authorValidator.validate(author, bindingResult);
        if(bindingResult.hasErrors())
            return "authors/new";
        //authorsService.save(author);
        return "redirect:/authors";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") long id){
        return "authors/edit";
    }


    @PatchMapping("/{id}")
    public String update(@ModelAttribute("author") @Valid Author author, BindingResult bindingResult, @PathVariable("id") int id){
        authorValidator.validate(author, bindingResult);
        if(bindingResult.hasErrors())
            return "authors/edit";

//        authorsService.update(id, author);
        return "redirect:/authors/" + id;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") long id){
//        authorsService.delete(id);
        return "redirect:/authors";
    }
}
