package my.project.library.controllers;

import jakarta.validation.Valid;
import my.project.library.models.Author;
import my.project.library.models.enums.sortings.AuthorsSorting;
import my.project.library.services.AuthorsService;
import my.project.library.utill.validators.AuthorValidator;
import my.project.library.utill.validators.ForPages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

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
    public String index(@RequestParam(value = "startingWith", required = false) String startingWith,
                        @RequestParam(value = "sort", required = false, defaultValue = "id_asc") AuthorsSorting sort,
                        @RequestParam(value = "page", required = false, defaultValue = "1") int page,
                        @RequestParam(value = "size", required = false, defaultValue = "5") int size,
                        Model model){

        model.addAttribute("sorting", Arrays.stream(AuthorsSorting.values()).toList());

        if(startingWith == null || startingWith.isEmpty()){
            long quantity = authorsService.countAll();
            page = ForPages.checkAndSaveValuesForPagination(page, size, quantity, model);

            model.addAttribute("authors", authorsService.findAll(page, size, sort));
        } else {
            long quantity = authorsService.countAllStartingWith(startingWith);
            page = ForPages.checkAndSaveValuesForPagination(page, size, quantity, model);

            model.addAttribute("startingWith", startingWith);
            model.addAttribute("authors", authorsService.findAllStartingWith(startingWith, page, size, sort));
        }


        return "authors/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") long id, Model model){
        model.addAttribute("author", authorsService.findOne(id).get());
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
        authorsService.save(author);
        return "redirect:/authors";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") long id, Model model){
        model.addAttribute("author", authorsService.findOne(id).get());
        return "authors/edit";
    }


    @PatchMapping("/{id}")
    public String update(@ModelAttribute("author") @Valid Author author, BindingResult bindingResult, @PathVariable("id") int id){
        authorValidator.validate(author, bindingResult);
        if(bindingResult.hasErrors())
            return "authors/edit";
        authorsService.update(id, author);
        return "redirect:/authors/" + id;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") long id){
        authorsService.delete(id);
        return "redirect:/authors";
    }
}
